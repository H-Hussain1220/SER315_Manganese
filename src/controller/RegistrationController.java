package controller;
import model.Race;
import model.Racer;
import strategy.OfficialRegistrationStrategy;
import strategy.RegistrationStrategy;
import strategy.UnofficialRegistrationStrategy;

public class RegistrationController {
    private RegistrationStrategy strategy;

    public void processRegistration(Racer racer, Race race) {
        if (race.isOfficial()) {
            this.strategy = new OfficialRegistrationStrategy();
        } else {
            this.strategy = new UnofficialRegistrationStrategy();
        }
        boolean success = strategy.register(racer, race);
        if (success) {
            System.out.println("Registration successful for " + racer.getName() + " in race: " + race.getRaceName());
        } else {
            System.out.println("Registration failed for " + racer.getName() + " in race: " + race.getRaceName());
        }
    }
    
}
