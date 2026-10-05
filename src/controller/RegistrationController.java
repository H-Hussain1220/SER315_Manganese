package controller;

import model.Race;
import model.RaceDivision;
import model.Racer;
import strategy.OfficialRegistrationStrategy;
import strategy.RegistrationStrategy;
import strategy.UnofficialRegistrationStrategy;
import model.AuthenticationService;

public class RegistrationController {
    private RegistrationStrategy strategy;
    private AuthenticationService authenticationService = new AuthenticationService();

    public boolean processRegistration(Racer racer, Race race, RaceDivision division) {
        if (!authenticationService.authenticateUser(racer)) {
            System.out.println("Registration failed: racer could not be identified.");
            return false;
        }

        if (!race.isRegistrationOpen()) {
            System.out.println("DEADLINE PASSED: The registration deadline has passed. Registration was not completed.");
            return false;
        }

        if (!race.hasSpace()) {
            System.out.println("RACE FULL: There are no spaces available for this race. Registration was not completed.");
            return false;
        }

        if (race.isOfficial()) {
            this.strategy = new OfficialRegistrationStrategy();
        } else {
            this.strategy = new UnofficialRegistrationStrategy();
        }
       return strategy.register(racer, race, division);
    }
    
}
