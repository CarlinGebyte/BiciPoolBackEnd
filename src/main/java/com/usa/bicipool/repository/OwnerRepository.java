/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.repository;

import com.usa.bicipool.interfaces.OwnerInterface;
import com.usa.bicipool.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Marco Moreno
 */
@Repository
public class OwnerRepository {

    /**
     * Crud
     */
    private OwnerInterface crud;

    /**
     * Constructor
     *
     * @param crud
     */
    public OwnerRepository(OwnerInterface crud) {
        this.crud = crud;
    }

    /**
     * @return crud.findAll()
     */
    public List<Owner> getAll() {
        return (List<Owner>) crud.findAll();
    }

    /**
     * @param id
     * @return crud.findById()
     */
    public Optional<Owner> getOwner(int id) {
        return crud.findById(id);
    }

    /**
     * @param owner
     * @return crud.save()
     */
    public Owner save(Owner owner) {
        return crud.save(owner);
    }

    /**
     * delete
     *
     * @param owner
     */
    public void delete(Owner owner) {
        crud.delete(owner);
    }

}
