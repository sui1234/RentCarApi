package com.example.rentCarApi;

public class Booking {

    private boolean isBooked;
    private String bookerName;


    public Booking(boolean isBooked, String bookerName) {
        this.isBooked = isBooked;
        this.bookerName = bookerName;
    }

    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean makeBooking() {
        if (!isBooked)
            return isBooked = true;
        return false;

    }
}
