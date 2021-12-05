/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "favorites")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Clase  Favorites
 */
public class Favorites implements Serializable {
    
    @Id
    /**
     * Variable idfavorites
     */
    private Integer idfavorites;
    
    @ManyToOne
    @JoinColumn(name="serial")
    @JsonIgnoreProperties({"favorites","reservations","scores","owner"})
    private Bike bike;
    
    @ManyToOne
    @JoinColumn(name="iddocument")
    @JsonIgnoreProperties({"favorites","reservations"})
    private User user;
}
