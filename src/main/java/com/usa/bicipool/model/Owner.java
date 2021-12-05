/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "owner")
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 * @author Marco Moreno
 */
public class Owner implements Serializable{
    
    
    @Id
    /**
     * Variable iddocument
     */
    private Integer idOwner;
    
    @Column
    /**
     * Variable email
     */
    private String email;
    
    @OneToOne
    @JoinColumn(name = "serial")//,referencedColumnName = "serial")
    @JsonIgnoreProperties({"owner","favorites","reservations"})
    private Bike bike;
}
