package strategy;
import model.Race;
import model.Racer;

public class OfficialRegistrationStrategy implements RegistrationStrategy {
    @Override 
    public boolean register(Racer racer, Race race) {
        System.out.println("Executing Official Race Registration Rules");
        return true;
    }
    
}
