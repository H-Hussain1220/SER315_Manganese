package model;
import java.util.ArrayList;
import java.util.List;
import observer.Observer;
import observer.Subject;

public class RaceResult implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String resultDetails;
    private int finishPosition;

    public void finalizeResults(String details, int finishPosition) {
        this.resultDetails = details;
        this.finishPosition = finishPosition;
        System.out.println("Race results finalized: " + details + " (Finished: #" + finishPosition + ")");
        if (finishPosition <= 3) {
            notifyObservers("Congratulations on your podium finish (#" + finishPosition + ")! You qualify for a Category Upgrade.");
        } else {
            notifyObservers("Results are in! You finished #" + finishPosition + ".");
        }
    }

    @Override 
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override 
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override 
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    
}
