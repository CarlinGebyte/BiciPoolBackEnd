/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.repository;

import com.usa.bicipool.interfaces.FavoritesInterface;
import com.usa.bicipool.model.Favorites;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Luis Baquero
 * @version 1.0
 */
@Repository
public class FavoritesRepository {

    private FavoritesInterface crud;

    public FavoritesRepository(FavoritesInterface crud) {
        this.crud = crud;
    }

    public List<Favorites> getAll() {
        return (List<Favorites>) crud.findAll();
    }

    public Optional<Favorites> getFavorites(int id) {
        return crud.findById(id);
    }

    public Favorites save(Favorites favorites) {
        return crud.save(favorites);
    }

    public void delete(Favorites favorites) {
        crud.delete(favorites);
    }

}
