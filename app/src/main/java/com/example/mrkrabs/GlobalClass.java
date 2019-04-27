package com.example.mrkrabs;

import android.app.Application;

public class GlobalClass extends Application {
    private String CurrentCity;
    private String DestinationCity;
    private String ExpectedSalary;

    private String Bedrooms;
    private String Location;
    private String RentPerMonth;
    private String Utilities;


    private String Grocery;
    private String Clothes;
    private String Transportation;
    private String TransportationCost;

    public String getGrocery() {
        return Grocery;
    }

    public void setGrocery(String grocery) {
        Grocery = grocery;
    }

    public String getClothes() {
        return Clothes;
    }

    public void setClothes(String clothes) {
        Clothes = clothes;
    }

    public String getTransportation() {
        return Transportation;
    }

    public void setTransportation(String transportation) {
        Transportation = transportation;
    }

    public String getTransportationCost() {
        return TransportationCost;
    }

    public void setTransportationCost(String transportationCost) {
        TransportationCost = transportationCost;
    }

    public String getBedrooms() {
        return Bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.Bedrooms = bedrooms;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getRentPerMonth() {
        return RentPerMonth;
    }

    public void setRentPerMonth(String rentPerMonth) {
        this.RentPerMonth = rentPerMonth;
    }

    public String getUtilities() {
        return Utilities;
    }

    public void setUtilities(String utilities) {
        this.Utilities = utilities;
    }

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

