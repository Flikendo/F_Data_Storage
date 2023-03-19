package com.flikendo.F_Data_Storage.Beans;

import static com.flikendo.F_Data_Storage.Beans.FuelStationBean.TypeFuel.UNKNOWN;

/**
 * Date: 03-12-2023
 * Author: Flikendo
 *
 * ProtoBean class. This class is used represent a protobuf as a bean to work with it
 */
public class FuelStationBean {
    private TypeFuel fuel;
    private int price;
    private String location;
    private String date;
    private String address;
    private String business;

    /**
     * Type of fuels
     */
    public enum TypeFuel {
        GAS_95,
        GAS_98,
        DIESEL,
        DIESEL_PLUS,
        UNKNOWN
    }

    /**
     * Constructor
     */
    public FuelStationBean() {
        this.fuel = UNKNOWN;
        this.price = 0;
        this.location = "";
        this.date = "";
        this.address = "";
        this.business = "";
    }

    /**
     * Getters & setters
     */
    public TypeFuel getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = TypeFuel.values()[fuel];
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
