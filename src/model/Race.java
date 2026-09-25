package model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private String raceName;
    private boolean isOfficial;

    private List<RaceDivision> divisions;

    public Race(String raceName, boolean isOfficial) {
        this.raceName = raceName;
        this.isOfficial = isOfficial;

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
    
}
