/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    /**
     * Variable idfavorites
     */
    private Integer idfavorites;

    @ManyToOne
    @JoinColumn(name = "serial")
    @JsonIgnoreProperties({"favorites", "reservations", "scores", "owner"})
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "iddocument")
    @JsonIgnoreProperties({"favorites", "reservations"})
    private User user;
}
