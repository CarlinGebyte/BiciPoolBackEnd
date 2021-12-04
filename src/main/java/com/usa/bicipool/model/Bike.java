/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.bicipool.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 * @author Marco Moreno
 */
public class Bike {
    
    @Id
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
    
    
}
