package strategy;
import model.Race;
import model.RaceDivision;
import model.Racer;

/**
 * Registration strategy for unofficial races.
 * Unofficial races do not require the racer to hold a valid racing license.
 */

public class UnofficialRegistrationStrategy implements RegistrationStrategy {
    @Override 
    public boolean register(Racer racer, Race race, RaceDivision division) {
        System.out.println("Executing Unofficial Race Registration Rules");
        return true;
    }
    
}
