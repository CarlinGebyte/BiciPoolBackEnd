/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.User;
import com.usa.bicipool.service.ServiciosUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/Registro")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    @Autowired
    private ServiciosUser service;
    
    
    
    @GetMapping("/all")
    public List<User> getUser(){
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return service.getUser(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
    }
    
    
    
    @GetMapping("/user/{email}/{password}")
    public ResponseEntity<?> buscarCorreoPass(@PathVariable String email,@PathVariable String password) {
        
        List <User> optional = service.getEmailPass(email,password);
        System.out.println(optional);

        if(optional.size()==0){

            User noencontrado = new User();
            noencontrado.setIddocument(null);
            noencontrado.setEmail(email);
            noencontrado.setPassword(password);
            
            return ResponseEntity.ok().body(noencontrado);
            
        }else{
            return ResponseEntity.ok().body(optional.get(0));
        }
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.deleteUser(id);
    } 
    
    
}
