/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.service;

import com.usa.bicipool.model.Favorites;
import com.usa.bicipool.repository.FavoritesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Luis Baquero
 * @version 1.0
 */
@Service
/**
 * Clase ServiciosFavorites
 */
public class ServiceFavorites {


    private FavoritesRepository metodCrud;

    public ServiceFavorites(FavoritesRepository metodCrud) {
        this.metodCrud = metodCrud;
    }

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
            if (emp.isPresent()) {

                if (favorites.getBike() != null) {
                    emp.get().setBike(favorites.getBike());
                }
                if (favorites.getUser() != null) {
                    emp.get().setUser(favorites.getUser());
                }
            }

            return metodCrud.save(emp.get());
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
