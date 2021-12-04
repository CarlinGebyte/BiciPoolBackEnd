/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.service;

import com.usa.bicipool.model.Favorites;
import com.usa.bicipool.repository.FavoritesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Baquero
 * @version 1.0
 *
 */
@Service
/**
 * Clase ServiciosFavorites
 */
public class ServiceFavorites {
    


    @Autowired
    private FavoritesRepository metodCrud;

    public List<Favorites> getAll() {
        return metodCrud.getAll();

    }

    public Optional<Favorites> getFavorites(int id) {
        return metodCrud.getFavorites(id);
    }

    public Favorites save(Favorites favorites) {
        if (favorites.getIdfavorites() == null) {
            return metodCrud.save(favorites);
        } else {
            Optional<Favorites> example = metodCrud.getFavorites(favorites.getIdfavorites());
            if (example.isEmpty()) {
                return metodCrud.save(favorites);
            } else {
                return favorites;
            }
        }
    }

    public Favorites update(Favorites favorites) {
        if (favorites.getIdfavorites() != null) {
            Optional<Favorites> emp = metodCrud.getFavorites(favorites.getIdfavorites());
            if (!emp.isEmpty()) {
                if (favorites.getIdfavorites() != null) {
                    emp.get().setIdfavorites(favorites.getIdfavorites());

                }
            }
                metodCrud.save(emp.get());
                return emp.get();
            } else {
                return favorites;
            }
     
    }
      public boolean deleteFavorites(int id) {
    Boolean aBoolean = getFavorites(id).map(favorites -> {
            metodCrud.delete(favorites);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
       


