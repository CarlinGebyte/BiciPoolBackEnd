package com.usa.bicipool.repository;

import com.usa.bicipool.interfaces.ReservationCrud;
import com.usa.bicipool.model.Reservations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
@Repository
public class ReservationRepository {
    /**
     * Atributo crud de la reservación
     */
    private ReservationCrud reservationCrud;

    /**
     * Constructor
     *
     * @param reservationCrud
     */
    public ReservationRepository(ReservationCrud reservationCrud) {
        this.reservationCrud = reservationCrud;
    }

    /**
     * Método para obtener todas las reservaciones
     *
     * @return
     */
    public List<Reservations> getAll() {
        return reservationCrud.findAll();
    }

    /**
     * Método para obtener una reservación por Id
     *
     * @param idReservation
     * @return
     */
    public Optional<Reservations> getById(Integer idReservation) {
        return reservationCrud.findById(idReservation);
    }

    /**
     * Método para guardar o actualizar una reservación
     *
     * @param reservations
     * @return
     */
    public Reservations save(Reservations reservations) {
        return reservationCrud.save(reservations);
    }

    /**
     * Método para eliminar una reservación
     *
     * @param idReservation
     */
    public void delete(Integer idReservation) {
        reservationCrud.deleteById(idReservation);
    }

}
