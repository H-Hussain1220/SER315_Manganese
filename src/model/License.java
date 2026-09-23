package model;

import java.time.LocalDate;


public class License {

    private String licenseID;
    private int categoryLevel;
    private LocalDate expirationDate;
    private boolean active;

    public License(String licenseID, int categoryLevel, LocalDate expirationDate, boolean active){
        this.licenseID = licenseID;
        this.categoryLevel = categoryLevel;
        this.expirationDate = expirationDate;
        this.active = active;
    }


    public boolean isValid() {
        return active && expirationDate.isBefore(LocalDate.now());
    }

    public String getLicenseID(){
        return licenseID;
    }

    public int getCategoryLevel() {
        return categoryLevel;
    }

    public LocalDate getExpirationDate(){
        return expirationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setCategoryLevel(int categoryLevel){
        this.categoryLevel = categoryLevel;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

