package com.example.mrkrabs;

import android.app.Application;
import android.widget.EditText;

import org.json.JSONArray;

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

    private String Fitness;
    private String Misc;
    private String Dining;
    private String Alcohol;

    private static String[] CurrentPrice = new String[24];
    private static String[] DestinationPrice = new String[24];

    public static String[] getCurrentPrice() { return CurrentPrice; }

    public static void setCurrentPrice(String[] currentPrice) { CurrentPrice = currentPrice; }

    public static String[] getDestinationPrice() { return DestinationPrice; }

    public static void setDestinationPrice(String[] destinationPrice) { DestinationPrice = destinationPrice; }

    public String getMisc() { return Misc; }

    public void setMisc(String misc) { Misc = misc; }

    public String getDining() { return Dining; }

    public void setDining(String dining) { Dining = dining; }

    public String getAlcohol() { return Alcohol; }

    public void setAlcohol(String alcohol) { Alcohol = alcohol; }

    public String getFitness() { return Fitness; }

    public void setFitness(String fitness) { Fitness = fitness; }

    public String getGrocery() {
        return Grocery;
    }

    public void setGrocery(String grocery) {
        this.Grocery = grocery;
    }

    public String getClothes() {
        return Clothes;
    }

    public void setClothes(String clothes) {
        this.Clothes = clothes;
    }

    public String getTransportation() {
        return Transportation;
    }

    public void setTransportation(String transportation) {
        this.Transportation = transportation;
    }

    public String getTransportationCost() {
        return TransportationCost;
    }

    public void setTransportationCost(String transportationCost) {
        this.TransportationCost = transportationCost;
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

