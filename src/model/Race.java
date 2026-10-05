package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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
    
    public boolean isRegistrationOpen() {
        return !LocalDate.now().isAfter(registrationDeadline);
    }

    public boolean hasSpace() {
        return spacesAvailable > 0;
    }

}
