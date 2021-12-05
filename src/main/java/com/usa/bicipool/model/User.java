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
import java.util.List;

/**
 * @author Luis Baquero
 * @version 1.0
 */
@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/**
 * Clase principal User
 */
public class User implements Serializable {

    @Id
    @Column
    /**
     * Variable iddocument
     */
    private Integer iddocument;

    @Column
    /**
     * Variable tipodocumento
     */
    private String tipodocumento;

    @Column
    /**
     * Variable apellidouno
     */
    private String apellidouno;

    @Column
    /**
     * Variable apellidodos
     */
    private String apellidodos;

    @Column
    /**
     * Variable nombreuno
     */
    private String nombreuno;

    @Column
    /**
     * Variable nombredos
     */
    private String nombredos;

    @Column
    /**
     * Variable birthdate
     */
    private String birthdate;

    @Column
    /**
     * Variable gender
     */
    private String gender;

    @Column
    /**
     * Variable city
     */
    private String city;

    @Column
    /**
     * Variable address
     */
    private String address;

    @Column
    /**
     * Variable telefonouno
     */
    private String telefonouno;

    @Column
    /**
     * Variable telefonodos
     */
    private String telefonodos;

    @Column
    /**
     * Variable email
     */
    private String email;

    @Column
    /**
     * Variable facebook
     */
    private String facebook;

    @Column
    /**
     * Variable instagram
     */
    private String instagram;

    @Column
    /**
     * Variable codeReference
     */
    private String codeReference;

    @Column
    /**
     * Variable tiposangre
     */
    private String tiposangre;

    @Column
    /**
     * Variable age
     */
    private Integer age;

    @Column
    /**
     * Variable password
     */
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "user")
    @JsonIgnoreProperties({"user", "bike", "favorites"})
    private List<Reservations> reservations;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "user")
    @JsonIgnoreProperties({"user", "bike", "reservations"})
    private List<Favorites> favorites;


}
