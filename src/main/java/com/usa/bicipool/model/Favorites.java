/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Luis Baquero
 * @version 1.0
 */
@Entity
@Table(name = "favoritos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Clase  Favorites
 */
public class Favorites implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Variable idfavorites
     */
    private Integer idfavorites;
}
