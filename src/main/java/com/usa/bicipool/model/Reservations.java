package com.usa.bicipool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @JoinColumn(name = "serial")
    @JsonIgnoreProperties({"reservations", "favorites", "user"})
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "iddocument")
    @JsonIgnoreProperties({"reservations", "favorites", "bike"})
    private User user;
}
