/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.service;

import com.usa.bicipool.model.Owner;
import com.usa.bicipool.repository.OwnerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marco Moreno
 */
@Service
public class OwnerService {

    /**
     *
     */
    @Autowired
    private OwnerRepository metodoCrud;

    /**
     *
     * @return metodocrud.getAll()
     */
    public List<Owner> getAll() {
        return metodoCrud.getAll();
    }

    /**
     *
     * @param id
     * @return metodoCrud.getOwner()
     */
    public Optional<Owner> getOwner(int id) {
        return metodoCrud.getOwner(id);
    }

    /**
     *
     * @param owner
     * @return
     */
    public Owner save(Owner owner) {
        if (owner.getIdOwner() == null) {
            return metodoCrud.save(owner);
        } else {
            Optional<Owner> example = metodoCrud.getOwner(owner.getIdOwner());
            if (example.isEmpty()) {
                return metodoCrud.save(owner);
            } else {
                return owner;
            }
        }
    }

    /**
     *
     * @param owner
     * @return
     */
    public Owner update(Owner owner) {
        if (owner.getIdOwner() != null) {
            Optional<Owner> emp = metodoCrud.getOwner(owner.getIdOwner());
            if (!emp.isEmpty()) {
                if (owner.getBike() != null) {
                    emp.get().setBike(owner.getBike());
                }
                if (owner.getEmail() != null) {
                    emp.get().setEmail(owner.getEmail());
                }

            }
            metodoCrud.save(emp.get());
            return emp.get();
        } else {
            return owner;
        }
    }

    /**
     *
     * @param id
     * @return metodoCrud.delete
     */
    public boolean deleteOwner(int id) {
        Boolean aBoolean = getOwner(id).map(user -> {
            metodoCrud.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
