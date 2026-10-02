package model;

public class AuthenticationService {
    // Mock login for the project demo
    public boolean authenticateUser(Racer racer) {
        if (racer == null) {
            return false;
        }

        System.out.println("Logged in as racer: " + racer.getName());
        return true;
    }
}
