package strategy;
import model.Race;
import model.RaceDivision;
import model.Racer;

public class OfficialRegistrationStrategy implements RegistrationStrategy {
    @Override 
    public boolean register(Racer racer, Race race, RaceDivision division) {
        System.out.println("Executing Official Race Registration Rules");

        System.out.println("\nLicense Check");
        System.out.println("Official race selected, checking Category" + division.getCategoryLevel() + " license");

        if(racer.getLicense() == null){
            System.out.println("License Error: a valid license is required. Cancelling Registration");
            return false;
        }

        if(!racer.getLicense().isValid()){
            System.out.println("License error: License is invalid or expired. Cancelling registration");
            return false;
        }

        if (racer.getLicense().getCategoryLevel() != division.getCategoryLevel()){
            System.out.println("License error: License category does not match selected race division. Cancelling Registration.");
        return false;
        }

        System.out.println("License is valid for Category " + division.getCategoryLevel() );
        return true;
    }
    
}
