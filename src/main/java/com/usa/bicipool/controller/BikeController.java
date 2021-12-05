/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.Bike;
import com.usa.bicipool.service.BikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Marco Moreno
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/bikes")
public class BikeController {

    /**
     * Atributo bikeService
     */
    private BikeService bikeService;

    /**
     * Constructor
     *
     * @param bikeService
     */
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    /**
     * Metodo para obtener todas las biciletas
     *
     * @return getAllBikes()
     */
    @GetMapping("/all")
    public List<Bike> listarBikes() {
        return bikeService.getAllBikes();
    }

    /**
     * Metodo para obtener una bicileta
     *
     * @param id
     * @return findSerial()
     */
    @GetMapping("/{id}")
    public Optional<Bike> findSerial(@PathVariable("id") String id) {
        return bikeService.findSerial(id);
    }

    /**
     * Metodo para guardar una bicicleta
     *
     * @param bike
     * @return saveBike()
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike) {
        return bikeService.saveBike(bike);
    }

    /**
     * Actualizar una bicicleta
     *
     * @param bike
     * @return update()
     */

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike) {
        return bikeService.update(bike);
    }

    /**
     * Metodo para eliminar una bicileta
     *
     * @param id
     * @return deleteBike()
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id) {
        return bikeService.deleteBike(id);
    }

}
