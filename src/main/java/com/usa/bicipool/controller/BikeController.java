/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.Bike;
import com.usa.bicipool.service.BikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marco Moreno
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/bikes")
public class BikeController {
    
    @Autowired
    private BikeService bikeService;
    
    @GetMapping("/all")
    public List<Bike> listarBikes(){
        return bikeService.getAllBikes();
    }
    
    @GetMapping("/{id}")
    public Optional<Bike> findSerial(@PathVariable("id") String id) {
        return bikeService.findSerial(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike) {
        return bikeService.saveBike(bike);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike) {
        return bikeService.update(bike);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id) {
        return bikeService.deleteBike(id);
    } 
    
}
