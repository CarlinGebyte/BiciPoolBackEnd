/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.Favorites;
import com.usa.bicipool.service.ServiceFavorites;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Luis Baquero
 * @version 1.0
 */
@RestController
@RequestMapping("/api/Favorites")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class FavoritesController {

    private ServiceFavorites service;

    public FavoritesController(ServiceFavorites service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Favorites> getFavorites() {
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
