package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Represents a race available for registration.
 * Stores whether the race is official, its registration deadline,
 * available capacity, and the category divisions offered by the race.
 */

public class Race {
    private String raceName;
    private boolean isOfficial;
    private LocalDate registrationDeadline;
    private int spacesAvailable;

    private List<RaceDivision> divisions;

    public Race(String raceName, boolean isOfficial, LocalDate registrationDeadline, int spacesAvailable) {
        this.raceName = raceName;
        this.isOfficial = isOfficial;
        this.registrationDeadline = registrationDeadline;
        this.spacesAvailable = spacesAvailable;
        //each race contains divisions for Categories 1-5
        divisions = new ArrayList<>();
        divisions.add(new RaceDivision(1));
        divisions.add(new RaceDivision(2));
        divisions.add(new RaceDivision(3));
        divisions.add(new RaceDivision(4));
        divisions.add(new RaceDivision(5));
    }
    public boolean isOfficial() {
        return isOfficial;
    }
    public String getRaceName() {
        return raceName;
    }
    //checks if registration is still open based on the deadline
    public boolean isRegistrationOpen() {
        return !LocalDate.now().isAfter(registrationDeadline);
    }

    public boolean hasSpace() {
        return spacesAvailable > 0;
    }

}
