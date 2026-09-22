package model;

public class Race {
    private String raceName;
    private boolean isOfficial;

    public Race(String raceName, boolean isOfficial) {
        this.raceName = raceName;
        this.isOfficial = isOfficial;
    }

    public boolean isOfficial() {
        return isOfficial;
    }
    public String getRaceName() {
        return raceName;
    }
    
}
