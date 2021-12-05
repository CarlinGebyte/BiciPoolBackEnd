/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.interfaces;

import com.usa.bicipool.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Marco Moreno
 * Version 1.0
 */
public interface OwnerInterface extends CrudRepository<Owner, Integer> {

}
