package com.example.mrkrabs;

import android.app.Application;

public class GlobalClass extends Application {
    private String CurrentCity;
    private String DestinationCity;
    private String ExpectedSalary;

    public String getCurrentCity() {
        return CurrentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.CurrentCity = currentCity;
    }

    public String getDestinationCity() {
        return DestinationCity;

    }

    public void setDestinationCity(String destinationCity) {
        this.DestinationCity = destinationCity;
    }

    public String getExpectedSalary() {
        return ExpectedSalary;

    }

    public void setExpectedSalary(String expectedSalary) {

        this.ExpectedSalary = expectedSalary;

    }
}

