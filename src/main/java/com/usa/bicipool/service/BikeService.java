/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.service;

import com.usa.bicipool.model.Bike;
import com.usa.bicipool.repository.BikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marco Moreno
 */
@Service
public class BikeService {
    /**
     * 
     */
    @Autowired
    private BikeRepository bikeRepository;
    
    /**
     * 
     * @return 
     */
    public List<Bike> getAllBikes(){
        return bikeRepository.getAllBikes();
    }
    
    /**
     * 
     * @param bike
     * @return 
     */
    public Bike saveBike(Bike bike){
    
        if (bike != null){
            return bikeRepository.saveBike(bike);
        }
        
        return null;
    }
    
    /**
     * 
     * @param serial
     * @return 
     */
    public Optional<Bike> findSerial(String serial){
        return bikeRepository.findSerial(serial);
    }
    
    /**
     * 
     * @param bike
     * @return 
     */
    public Bike update(Bike bike) {
        if (bike.getSerial()!= null) {
            Optional<Bike> emp = bikeRepository.findSerial(bike.getSerial());
            if (!emp.isEmpty()) {
                if (bike.getSerial()!= null) {
                    emp.get().setSerial(bike.getSerial());

                }
            }
            bikeRepository.saveBike(emp.get());
                return emp.get();
            } else {
                return bike;
            }
     
    }
    
    /**
     * 
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
