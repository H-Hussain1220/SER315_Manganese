package model;


/**
 * Provides simplified authentication for the console prototype.
 * This implementation verifies that a racer can be identified
 * without implementing password or credential management.
 * Very minimalist for prototyping.
 */
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
