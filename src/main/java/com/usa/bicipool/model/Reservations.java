package com.usa.bicipool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author CarlinGebyte
 */
@Entity
@Table(name = "reservations")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservations implements Serializable {
    /**
     * Atributo Id de la reservación
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Integer idReservation;

    /**
     * Atributo fecha de la reservación
     */
    @NotNull
    @Column(name = "reservation_date")
    private Date reservationDate;
}
