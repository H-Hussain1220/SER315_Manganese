package model;
import observer.Observer;

public class Racer implements Observer {
    private String name;
    private int currentCategory;
    private License license;


    //overloaded constructor to allow racer to be created without a license
    public Racer(String name, int category) {
        this.name = name;
        this.currentCategory = category;
    }

    public Racer(String name, int category, License license) {
        this.name = name;
        this.currentCategory = category;
        this.license = license;
    }

    @Override 
    public void update(String message) {
        if (message.contains("Category Upgrade") && currentCategory > 1) {
            currentCategory--;
            if (license != null) {
                license.setCategoryLevel(currentCategory);
            }
            System.out.println("Notification for " + name + ": " + message + " [Upgraded to Cat " + currentCategory + "!]");
        } else {
            System.out.println("Notification for " + name + ": " + message);
        }
    }

    public String getName() {
        return name;
    }

    public License getLicense(){
        return license;
    }

    public void setLicense(License license){
        this.license = license;
    }
    
}
