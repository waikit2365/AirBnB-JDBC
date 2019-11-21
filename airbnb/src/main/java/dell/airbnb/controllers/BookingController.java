package main.java.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dell.airbnb.entities.Booking;
import dell.airbnb.repositories.BookingRepository;

@RestController
public class BookingController {

    @Autowired
    BookingRepository repo;

    @Autowired
    CreateBookingService createBookingService;

    @GetMapping(value = "/booking")
    public List<Booking> index() {
        return repo.getAll();
    }

    @GetMapping(value = "/booking/{id}")
    public Booking show(@PathVariable("id") int id){
        Booking booking = repo.getOne(id);
        return booking;
    }

    @PostMapping(value = "/booking")
    public Booking create(@RequestBody Booking booking){
        return createBookingService.run(booking);
    }

    @PostMapping(value = "/booking/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody Booking newBooking){
        repo.updateBooking(id,newBooking);
    }

    @DeleteMapping(value = "/booking/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteBooking(id);
    }
}