/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.interfaces;

import com.usa.bicipool.model.Bike;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marco Moreno
 */
public interface BikeInterface extends CrudRepository <Bike, String> {
    
}
