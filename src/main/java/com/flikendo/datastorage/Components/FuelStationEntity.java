package com.flikendo.datastorage.Components;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

/**
 * Date: 03-16-2023
 * Author: Flikendo
 *
 * FuelStationEntity class. This class represent a MongoDB document
 */
@Document("fuelstations")
public class FuelStationEntity {
    @Id
    private String id;
    private FuelStation.TypeFuel fuel;
    private int price;
    private String location;
    private String date;
    private String address;
    private String business;

    /**
     * Constructor
     * @param id Entity identifier
     * @param fuel Type of fuel
     * @param price Price of fuel
     * @param location Location of fuel station
     * @param date Date of fuel/price
     * @param address Address of fuel station
     * @param business Fuel station business
     */
    public FuelStationEntity(String id, FuelStation.TypeFuel fuel, int price, String location, String date, String address, String business) {
        this.id = id;
        this.fuel = fuel;
        this.price = price;
        this.location = location;
        this.date = date;
        this.address = address;
        this.business = business;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FuelStation.TypeFuel getFuel() {
        return fuel;
    }

    public void setFuel(FuelStation.TypeFuel fuel) {
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
