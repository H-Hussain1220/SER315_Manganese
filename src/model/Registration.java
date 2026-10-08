package model;

import java.time.LocalDate;

/**
 * Represents a racer's registration for a specific race and division.
 * Stores the information associated with the registration record.
 */

public class Registration {
    private Racer racer;
    private Race race;
    private RaceDivision division;
    private LocalDate registrationDate;
    private String status;

    public Registration(Racer racer, Race race, RaceDivision division) {
        this.racer = racer;
        this.race = race;
        this.division = division;
        this.registrationDate = LocalDate.now();
        this.status = "Completed";
    }

    public void printRegistrationInfo() {
        System.out.println("[System: Registration Record Created for " + racer.getName() + " - " + race.getRaceName() + "]");
    }
    
}
