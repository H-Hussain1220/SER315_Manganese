package strategy;
import model.Race;
import model.RaceDivision;
import model.Racer;

public interface RegistrationStrategy {
    boolean register(Racer racer, Race race, RaceDivision division);
}
