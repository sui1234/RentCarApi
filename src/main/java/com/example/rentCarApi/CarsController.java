package com.example.rentCarApi;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

@RestController
public class CarsController {


    private Cars cars = new Cars(false);

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<CarsItem> getCarsItems(@RequestParam(value = "searchString", defaultValue = "") String searchString) {

        return cars.getCarsItemList(searchString);

    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public CarsItem postCarsItem(@RequestBody CarsItem item) {

        cars.addItem(item);
        return item;

    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public CarsItem getCarsItem(@PathVariable("id") String itemId) {

        CarsItem item = cars.getCarsItem(itemId);
        return item;

    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
    public CarsItem deleteCarsItem(@PathVariable("id") String itemId) {

        return cars.deleteCarsItem(itemId);
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.PUT)
    public CarsItem putCarsItem(@PathVariable("id") String itemId,
                                @RequestBody CarsItem item) {

        cars.updateCarsItemWithId(itemId, item);
        return item;


    }

    @RequestMapping(value = "/cars/{id}/booking", method = RequestMethod.GET)
    public Booking getBookingItem(@PathVariable("id") String itemId) {
        Booking item = cars.getCarsItem(itemId).getBooking();
        return item;

    }


    @RequestMapping(value = "/cars/{id}/booking", method = RequestMethod.PUT)
    public Booking putCarsBookingItem(@PathVariable("id") String itemId,
                                       @RequestBody Booking item){

        cars.updateBookersNameWithId(itemId, item);
        return item;
    }



}
