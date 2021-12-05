/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.repository;

import com.usa.bicipool.interfaces.OwnerInterface;
import com.usa.bicipool.model.Owner;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marco Moreno
 */
@Repository
public class OwnerRepository {
    
    /**
//     * Crud
     */
    @Autowired
    private OwnerInterface crud;
    
    /**
     * 
     * @return crud.findAll()
     */
    public List<Owner> getAll(){
        return (List<Owner>) crud.findAll();
    }
    
    /**
     * 
     * @param id
     * @return crud.findById()
     */
    public Optional<Owner> getOwner(int id){
        return crud.findById(id);
    }
    /**
     * 
     * @param owner
     * @return crud.save()
     */
    public Owner save(Owner owner){
        return crud.save(owner);
    }
    /**
     * delete
     * @param owner 
     */
    public void delete(Owner owner){
        crud.delete(owner);
    }
  
}
