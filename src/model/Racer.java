package model;
import observer.Observer;

public class Racer implements Observer {
    private String name;
    private int currentCategory;

    public Racer(String name, int category) {
        this.name = name;
        this.currentCategory = category;
    }

    @Override 
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }

    public String getName() {
        return name;
    }
    
}
