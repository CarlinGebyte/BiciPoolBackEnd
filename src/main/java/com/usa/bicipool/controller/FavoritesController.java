/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.Favorites;
import com.usa.bicipool.service.ServiceFavorites;
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
 * @author Luis Baquero
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/api/Favorites")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class FavoritesController {
   @Autowired
    private ServiceFavorites service;
    
    
    
    @GetMapping("/all")
    public List<Favorites> getFavorites(){
        return service.getAll();
    }
    
     @GetMapping("/{id}")
    public Optional<Favorites> getFavorites(@PathVariable("id") int id) {
        return service.getFavorites(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Favorites save(@RequestBody Favorites favorites) {
        return service.save(favorites);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Favorites update(@RequestBody Favorites favorites) {
        return service.update(favorites);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.deleteFavorites(id);
    } 
    
    
}
