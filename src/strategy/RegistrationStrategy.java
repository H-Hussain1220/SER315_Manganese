package strategy;
import model.Race;
import model.RaceDivision;
import model.Racer;


/**
 * Defines the registration behavior used by different race types.
 * Implementations perform race-specific eligibility checks and return
 * whether the racer is allowed to continue with registration.
 */
public interface RegistrationStrategy {
    boolean register(Racer racer, Race race, RaceDivision division);
}
