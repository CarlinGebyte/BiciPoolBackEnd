/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.User;
import com.usa.bicipool.service.ServiciosUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Luis Baquero
 * @version 1.0
 */
@RestController
@RequestMapping("/api/Registro")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    private ServiciosUser service;

    public UserController(ServiciosUser service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<User> getUser() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return service.getUser(id);
    }

    @GetMapping("/user/{email}/{password}")
    public ResponseEntity<?> buscarCorreoPass(@PathVariable String email, @PathVariable String password) {

        Optional<User> optional = service.getEmailPass(email,password);
        System.out.println(optional);

        if(optional.isEmpty()){

            User noencontrado = new User();
            noencontrado.setIddocument(null);
            noencontrado.setEmail(email);
            noencontrado.setPassword(password);

            return ResponseEntity.ok().body(noencontrado);

        }else{
            return ResponseEntity.ok().body(optional.get());
        }
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
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
