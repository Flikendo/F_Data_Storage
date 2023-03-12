package com.flikendo.F_Data_Storage.Beans;

/**
 * Date: 03-12-2023
 * Author: Flikendo
 *
 * ProtoBean class. This class is used represent a protobuf as a bean to work with it
 */
public class ProtoBean {
    private int fuel;
    private int price;
    private String location;
    private String date;
    private String address;
    private String business;

    /**
     * Constructor
     * @param fuel type of fuel
     * @param price price of fuel
     * @param location city/town of the fuel-station
     * @param date date of the fuel's price
     * @param address fuel-station's address
     * @param business fuel-station's company
     */
    public ProtoBean(int fuel, int price, String location, String date, String address, String business) {
        this.fuel = fuel;
        this.price = price;
        this.location = location;
        this.date = date;
        this.address = address;
        this.business = business;
    }

    /**
     * Getters & setters
     */
    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}
