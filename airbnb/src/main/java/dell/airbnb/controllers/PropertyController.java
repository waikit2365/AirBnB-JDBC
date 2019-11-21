package main.java.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dell.airbnb.entities.Property;
import dell.airbnb.repositories.PropertyRepository;

@RestController
public class PropertyController {

    @Autowired
    PropertyRepository repo;

    @Autowired
    CreatePropertyService createPropertyService;

    @GetMapping(value = "/property")
    public List<Property> index() {
        return repo.getAll();
    }

    @GetMapping(value = "/property/{id}")
    public Property show(@PathVariable("id") int id){
        Property property = repo.getOne(id);
        return property;
    }

    @PostMapping(value = "/property")
    public Property create(@RequestBody Property property){
        return createPropertyService.run(property);
    }

    @PostMapping(value = "/property/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody Property newProperty){
        repo.updateProperty(id,newProperty);
    }

    @DeleteMapping(value = "/property/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteProperty(id);
    }
}