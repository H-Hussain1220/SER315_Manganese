package view;
import controller.RegistrationController;
import java.time.LocalDate;
import java.util.Scanner;
import model.License;
import model.Race;
import model.RaceResult;
import model.Racer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationController regController = new RegistrationController();
        RaceResult results = new RaceResult(); //Subject for Observer

        //mock data for testing purposes
        Race officialRace = new Race("Desert Bike Race", true);
        Race unofficialRace = new Race("Mountain Bike Race", false);

        System.out.println("Welcome to the Race Registration System!");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Available Races---");
            System.out.println("1. " + officialRace.getRaceName() + " (Official)");
            System.out.println("2. " + unofficialRace.getRaceName() + " (Unofficial)");
            System.out.println("3. Exit");
            System.out.print("\nSelect an option (1-3): ");

            String choice = scanner.nextLine();
            if (choice.equals("3")) {
                running = false;
                System.out.println("Exiting the Race Registration System. Goodbye!");
                continue;
            }

            Race selectedRace = choice.equals("1") ? officialRace : unofficialRace;

            System.out.println("\n--- " + selectedRace.getRaceName().toUpperCase() + " DETAILS ---");
            System.out.println("Type: Road Race");
            System.out.println("Status: " + (selectedRace.isOfficial() ? "Official" : "Unofficial"));
            System.out.println("Distance: 25 miles");

            System.out.print("\nEnter your name to begin: ");
            String racerName = scanner.nextLine();

            System.out.println("\nSelect category:");
            System.out.println("1. Cat 5\n2. Cat 4\n3. Cat 3");
            System.out.print("Choose (1-3): ");
            String catInput = scanner.nextLine();
            int category = 3; // defaults to Cat 3 for the simulation
            if (catInput.equals("1")) category = 5;
            if (catInput.equals("2")) category = 4;

            //generate valid mock license
            License testLicense = new License("testLicense1", category, LocalDate.now().plusYears(1), true);
            
            Racer currentRacer = new Racer(racerName, category, testLicense);


            if (selectedRace.isOfficial()) {
                System.out.println("\nLicense Check");
                System.out.println("Official race selected. Checking Cat " + category + " license...");
                if (currentRacer.getLicense() != null && currentRacer.getLicense().isValid()) {
                    System.out.println("License is valid. Continue to payment.");
                } else {
                    System.out.println("LICENSE ERROR: A valid license is required. Registration cancelled.");
                    continue;
                }
            }
            
            System.out.println("\nPAYMENT");
            System.out.print("Name on card: ");
            scanner.nextLine();
            System.out.print("Card number: ");
            scanner.nextLine();
            System.out.print("Amount: $25.00. Submit payment? (Y/N): ");
            String payChoice = scanner.nextLine();

            if (payChoice.equalsIgnoreCase("Y")) {
                System.out.println("Payment successful.");
                
                System.out.println("\n--- PROCESSING REGISTRATION ---");
                //trigger Strategy Pattern
                regController.processRegistration(currentRacer, selectedRace);

                //attach racer to RaceResult system for Observer pattern
                results.attach(currentRacer); 
                
                System.out.println("\n[System: Simulating Event... Organizer posts race results]");
                //trigger Observer Pattern (notification section)
                results.finalizeResults(selectedRace.getRaceName() + " Cat " + category + " placements posted.");
                
            } else {
                System.out.println("\nPAYMENT FAILED");
                System.out.println("Registration was not completed. Returning to menu.");
            }

        }
        scanner.close();
    }
}
