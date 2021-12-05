/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.service;

import com.usa.bicipool.model.Bike;
import com.usa.bicipool.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Marco Moreno
 */
@Service
public class BikeService {

    /**
     * Repositorio
     */
    private BikeRepository bikeRepository;

    /**
     * Constructor
     *
     * @param bikeRepository
     */
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    /**
     * @return
     */
    public List<Bike> getAllBikes() {
        return bikeRepository.getAllBikes();
    }

    /**
     * @param bike
     * @return
     */
    public Bike saveBike(Bike bike) {

        if (bike != null) {
            return bikeRepository.saveBike(bike);
        }

        return null;
    }

    /**
     * @param serial
     * @return
     */
    public Optional<Bike> findSerial(String serial) {
        return bikeRepository.findSerial(serial);
    }

    /**
     * @param bike
     * @return
     */
    public Bike update(Bike bike) {
        if (bike.getSerial() != null) {
            Optional<Bike> emp = bikeRepository.findSerial(bike.getSerial());
            if (emp.isPresent()) {
                if (bike.getSerial() != null) {
                    emp.get().setBrand(bike.getBrand());
                }
                if (bike.getColor() != null) {
                    emp.get().setColor(bike.getColor());
                }
                if (bike.getFavorites() != null) {
                    emp.get().setFavorites(bike.getFavorites());
                }
                if (bike.getOwner() != null) {
                    emp.get().setOwner(bike.getOwner());
                }
                if (bike.getReservations() != null) {
                    emp.get().setReservations(bike.getReservations());
                }
                if (bike.getScores() != null) {
                    emp.get().setScores(bike.getScores());
                }
                if (bike.getSize() != null) {
                    emp.get().setSize(bike.getSize());
                }
                if (bike.getStatus() != null) {
                    emp.get().setStatus(bike.getStatus());
                }
                if (bike.getTimeUsed() != null) {
                    emp.get().setTimeUsed(bike.getTimeUsed());
                }
                if (bike.getType() != null) {
                    emp.get().setType(bike.getType());
                }

            }
            bikeRepository.saveBike(emp.get());
            return emp.get();
        } else {
            return bike;
        }

    }

    /**
     * @param serial
     * @return
     */
    public boolean deleteBike(String serial) {
        Boolean aBoolean = findSerial(serial).map(bike -> {
            bikeRepository.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
