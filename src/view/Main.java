package view;
import controller.RegistrationController;
import java.time.LocalDate;
import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationController regController = new RegistrationController();


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
            RaceDivision selectedDivision = new RaceDivision(category);

            //allow testing for valid and invalid licenses in CLI
            License racerLicense = null;
            if (selectedRace.isOfficial()) {
                System.out.print("\n[Simulation] Do you hold a valid Cat " + category + " license? (Y/N): ");
                String hasLic = scanner.nextLine();
                if (hasLic.equalsIgnoreCase("Y")) {
                    racerLicense = new License("LIC-1001", category, LocalDate.now().plusYears(1), true);
                }
            }
            
            Racer currentRacer = new Racer(racerName, category, racerLicense);

            System.out.println("\n--- VALIDATING REGISTRATION ---");
            //moved to trigger strategy before payment
            boolean eligible = regController.processRegistration(currentRacer, selectedRace, selectedDivision);

            if (!eligible) {
                System.out.println("Registration failed for " + currentRacer.getName() + " in race: "
                        + selectedRace.getRaceName());
                continue;
            }


            //payment processing
            System.out.println("\nPAYMENT");
            System.out.print("Name on card: ");
            scanner.nextLine();
            System.out.print("Card number: ");
            scanner.nextLine();
            System.out.print("Amount: $25.00. Submit payment? (Y/N): ");
            String payChoice = scanner.nextLine();

            if (payChoice.equalsIgnoreCase("Y")) {
                System.out.println("Payment successful.");
                
                System.out.println("\nREGISTRATION CONFIRMED");
                System.out.println("Registration successful for " + currentRacer.getName() + " in race: " + selectedRace.getRaceName() + " (Cat " + category + ")");

                //trigger observer pattern for race results and cat upgrade notification
                RaceResult results = new RaceResult();
                results.attach(currentRacer);

                System.out.println("\n[System: Simulating Event... Organizer posts race results]");
                results.finalizeResults(selectedRace.getRaceName() + " Cat " + selectedDivision.getCategoryLevel() + " placements posted.", 1);
            } else {
                System.out.println("\nPAYMENT FAILED");
                System.out.println("Please check your card and try again. Registration was not completed.");
            }

        }
        scanner.close();
    }
}
