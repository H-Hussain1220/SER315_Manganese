package model;

/**
 * Represents a category division within a race.
 * Each race supports category levels 1 through 5.
 */
public class RaceDivision {

    private int categoryLevel;

    public RaceDivision(int categoryLevel){
        this.categoryLevel = categoryLevel;
    }

    public int getCategoryLevel() {
        return categoryLevel;
    }
}
