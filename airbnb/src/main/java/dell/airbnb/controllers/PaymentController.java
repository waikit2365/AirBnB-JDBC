package main.java.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dell.airbnb.entities.Payment;
import dell.airbnb.repositories.PaymentRepository;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository repo;

    @Autowired
    CreatePaymentService createPaymentService;

    @GetMapping(value = "/payment")
    public List<Payment> index() {
        return repo.getAll();
    }

    @GetMapping(value = "/payment/{id}")
    public Payment show(@PathVariable("id") int id){
        Payment payment = repo.getOne(id);
        return payment;
    }

    @PostMapping(value = "/payment")
    public Payment create(@RequestBody Payment payment){
        return createPaymentService.run(payment);
    }

    @PostMapping(value = "/payment/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody Payment newPayment){
        repo.updatePayment(id,newPayment);
    }

    @DeleteMapping(value = "/payment/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deletePayment(id);
    }
}