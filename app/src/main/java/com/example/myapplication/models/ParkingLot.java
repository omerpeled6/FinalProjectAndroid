package com.example.myapplication.models;

public class ParkingLot {

    private String name;
    private String address;
    private String numOfParks;
    private String numOfDisabled;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumOfParks() {
        return numOfParks;
    }

    public String getNumOfDisabled() {
        return numOfDisabled;
    }

    public ParkingLot(String name, String address, String numOfParks, String numOfDisabled) {
        this.name = name;
        this.address = address;
        this.numOfParks = numOfParks;
        this.numOfDisabled = numOfDisabled;
    }
}
