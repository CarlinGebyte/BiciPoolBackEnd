/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.controller;

import com.usa.bicipool.model.Owner;
import com.usa.bicipool.service.OwnerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 * @author Marco Moreno
 */
@RestController
@RequestMapping("/api/owner")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OwnerController {
    
    /**
     * Atributo Servicio
     */
    @Autowired
    private OwnerService service;
    
    
    /**
     * Método para obtener todos los propietarios
     * @return getAll()
     */
    @GetMapping("/all")
    public List<Owner> getOwner(){
        return service.getAll();
    }
    
    /**
     * Método para traer un propietario
     * @param id
     * @return getOwner()
     */
    @GetMapping("/{id}")
    public Optional<Owner> getOwner(@PathVariable("id") int id) {
        return service.getOwner(id);
    }
    
    /**
     * Metodo para crear un propietario
     * @param owner
     * @return save()
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Owner save(@RequestBody Owner owner) {
        return service.save(owner);
    }
    
    /**
     * Metodo para actualizar un propietario
     * @param owner
     * @return update()
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Owner update(@RequestBody Owner owner) {
        return service.update(owner);
    }
    
    /**
     * Metodo para eliminar un propietario
     * @param id
     * @return deleteOwner()
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.deleteOwner(id);
    }
    
}
