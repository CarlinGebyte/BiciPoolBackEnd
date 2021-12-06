/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.bicipool.interfaces;

import com.usa.bicipool.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


/**
 * @author Luis Baquero
 * @version 1.0
 */
public interface UserInterface extends CrudRepository<User, Integer> {
    public Optional<User> findByEmailAndPassword(String email, String password);

}
