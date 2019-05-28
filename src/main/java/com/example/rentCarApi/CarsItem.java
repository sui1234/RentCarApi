package com.example.rentCarApi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private String id;
    private String price;
    private String color;
    private String brand;
    private String type;

    private Booking booking;

    public CarsItem() {
    }

    public CarsItem(String id, String price, String color, String brand, String type, Booking booking) {
        this.id = id;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.type = type;
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
