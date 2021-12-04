/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.repository;




import com.usa.bicipool.interfaces.UserInterface;
import com.usa.bicipool.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Luis Baquero
 * @version 1.0
 */

@Repository
public class UserRepository {
    @Autowired
    private UserInterface crud;
    
    public List<User> getAll(){
        return (List<User>) crud.findAll();
    }
    
    public Optional<User> getUser(int id){
        return crud.findById(id);
    }
    public User save(User user){
        return crud.save(user);
    }
    public void delete(User user){
        crud.delete(user);
    }

  
    
}
