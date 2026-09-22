package model;
import observer.Subject;
import observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class RaceResult implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String resultDetails;

    public void finalizeResults(String details) {
        this.resultDetails = details;
        System.out.println("Race results finalized: " + details);
        notifyObservers("Results are in! Check to see if you earned an upgrade.");
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
