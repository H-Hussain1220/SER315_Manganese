package view;
import model.Race;
import model.Racer;
import model.RaceResult;
import controller.RegistrationController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Race Registration System!");

        Racer testRacer = new Racer("Speed Racer", 3);
        Race officialRace = new Race("Desert Bike Race", true);
        
        System.out.println("\n--- Testing Registration Strategy ---");
        RegistrationController regController = new RegistrationController();
        regController.processRegistration(testRacer, officialRace);

        System.out.println("\n--- Testing Observer Notification ---");
        RaceResult results = new RaceResult();
        results.attach(testRacer);
        results.finalizeResults("Desert Bike Race Cat 3 placements posted.");
    }
    
}
