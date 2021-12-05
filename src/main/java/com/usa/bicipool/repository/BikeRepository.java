/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.repository;

import com.usa.bicipool.interfaces.BikeInterface;
import com.usa.bicipool.model.Bike;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
/**
 *
 * @author Marco Moreno
 */
public class BikeRepository {

    private BikeInterface bikeRepo;

    public BikeRepository(BikeInterface bikeRepo) {
        this.bikeRepo = bikeRepo;
    }

    public List<Bike> getAllBikes() {
        return (List<Bike>) bikeRepo.findAll();
    }

    public Bike saveBike(Bike bikeEntity) {
        return bikeRepo.save(bikeEntity);
    }

    public Optional<Bike> findSerial(String Serial) {
        return bikeRepo.findById(Serial);
    }

    public void delete(Bike bike) {
        bikeRepo.delete(bike);
    }

}
