package controller;
import model.Race;
import model.RaceDivision;
import model.Racer;
import strategy.OfficialRegistrationStrategy;
import strategy.RegistrationStrategy;
import strategy.UnofficialRegistrationStrategy;

public class RegistrationController {
    private RegistrationStrategy strategy;

    public boolean processRegistration(Racer racer, Race race, RaceDivision division) {
        if (race.isOfficial()) {
            this.strategy = new OfficialRegistrationStrategy();
        } else {
            this.strategy = new UnofficialRegistrationStrategy();
        }
       return strategy.register(racer, race, division);
    }
    
}
