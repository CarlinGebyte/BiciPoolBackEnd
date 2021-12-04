/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.bicipool.interfaces;

import com.usa.bicipool.model.Favorites;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PERSONALCASA
 */
public interface FavoritesInterface extends CrudRepository<Favorites,Integer>{
    
}
