package com.usa.bicipool.service;

import com.usa.bicipool.model.Reservations;
import com.usa.bicipool.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
@Service
public class ReservationService {
    /**
     * Atributo repositorio de reservaciones
     */
    private ReservationRepository repository;

    /**
     * Constructor
     * @param repository
     */
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    /**
     * Método para obtener todas las reservaciones
     * @return
     */
    public List<Reservations> getAll() {
        return repository.getAll();
    }

    /**
     * Método para crear una reservación
     * @param reservation
     * @return
     */
    public Reservations save(Reservations reservation) {
        return repository.save(reservation);
    }

    /**
     * Método para actualizar una reservación
     * @param reservation
     * @return
     */
    public Reservations update(Reservations reservation) {
        Optional<Reservations> exist = repository.getById(reservation.getIdReservation());
        if (exist.isPresent()) {
            exist.get().setReservationDate(reservation.getReservationDate());
            return exist.get();
        } else {
            return reservation;
        }
    }

    /**
     * Método para eliminar una reservación
     * @param idReservation
     */
    public void delete(Integer idReservation) {
        repository.delete(idReservation);
    }
}
