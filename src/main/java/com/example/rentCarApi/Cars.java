package com.example.rentCarApi;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import sun.rmi.runtime.Log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

@Entity
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private List<CarsItem> cars;
    private boolean isCarBooked;


    public Cars() {
        this.cars = new ArrayList<>();
        // addItems();
        //writeToFile();
        //  readFromFile();
    }

    public Cars(Boolean b) {

        this.cars = new ArrayList<>();
        readFromFile();
    }


    public List<CarsItem> getCarsItemList(String searchString) {

        if (searchString.equals(null)) {
            return cars;
        }

        ArrayList<CarsItem> items = new ArrayList<>();
        for (CarsItem item : cars) {
            if (item.getBrand().toLowerCase().contains(searchString.toLowerCase())) {
                items.add(item);
            }
        }
        return items;
    }

    public void addItem(CarsItem item) {

        cars.add(item);
        writeToFile();

    }
    /*public void addBookingItem(String id, Booking item){
        booking = new ArrayList<Booking>();
        Booking item1 = getCarsItem(id).getBooking();
        isCarBooked = item1.isBooked();
        if(isCarBooked = true){
            booking.add(item);
        }
    }*/


    public CarsItem getCarsItem(String id) {
        return findItemById(id);

    }

    public CarsItem deleteCarsItem(String id) {
        CarsItem carsItem = getCarsItem(id);
        cars.remove(carsItem);
        writeToFile();
        return carsItem;
    }

    public void updateCarsItemWithId(String id, CarsItem newItem) {
        CarsItem oldItem = findItemById(id);
        cars.remove(oldItem);
        newItem.setId(oldItem.getId());
        cars.add(newItem);
        writeToFile();
    }


    public void updateBookersNameWithId(String id, Booking newBookingItem) {

        Booking oldItem = findItemById(id).getBooking();
        oldItem.setBookerName(newBookingItem.getBookerName());
        oldItem.makeBooking();
        writeToFile();
    }

    private CarsItem findItemById(String id) {
        for (CarsItem item : cars) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void addItems() {

        Booking booking1 = new Booking(false, "Yujie");
        Booking booking2 = new Booking(false, "Mina");
        Booking booking3 = new Booking(true, "");

        CarsItem item1 = new CarsItem("0", "400kr/day", "blue", "VOLVO", "XC60", booking1);
        CarsItem item2 = new CarsItem("1", "280kr/day", "black", "VOLVO", "V60", booking2);
        CarsItem item3 = new CarsItem("2", "300kr/day", "red", "AUDI", "A4", booking3);

        cars.add(item1);
        cars.add(item2);
        cars.add(item3);

    }


    void writeToFile() {


        try (FileWriter file = new FileWriter("myJSON.json")) {
            Gson gson = new GsonBuilder().create();

            gson.toJson(this, file);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFromFile() {

        Gson gson = new Gson();

        try {
            JsonReader reader = new JsonReader(new FileReader("myJSON.json"));
            Cars cars = gson.fromJson(reader, Cars.class);

            this.cars = cars.cars;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





     /*public void updateCars(String id, String price) {
        if (!carMap.containsKey(id)) {

            throw new IllegalArgumentException("The car does not exist for id: " + id);
        }
        CarsItem carsItem = carMap.get(id);
        carsItem.setPrice(price);
    }
*/
}

