/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bikes")
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 * @author Marco Moreno
 */
public class Bike implements Serializable {

    @Id
    @Column
    /**
     * Variable serial: es el código identificador de la bicicleta
     */
    private String serial;

    @Column
    /**
     * Variable Brand
     */
    private String brand;

    @Column
    /**
     * Variable Size
     */
    private String size;

    @Column
    /**
     * Variable type: clasificación de la bicileta ej: Mountain, Ruta, Urbana, etc..
     */
    private String type;

    @Column
    /**
     * Color
     */
    private String color;

    @Column
    /**
     * Variable timeUsedUso: Horas de uso de la Bicicleta en la aplicación
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date timeUsed;

    @Column
    /**
     * Variable status: Estado de la Bicicleta ej: Bueno, Regular, Malo
     */
    private String status;

    @OneToOne(mappedBy = "bike")
    @JsonIgnoreProperties("bike")
    private Owner owner;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties("bike")
    private List<Score> scores;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "reservations", "user"})
    private List<Favorites> favorites;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "favorites", "user"})
    private List<Reservations> reservations;

}
