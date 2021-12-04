package com.usa.bicipool.controller;

import com.usa.bicipool.model.Reservations;
import com.usa.bicipool.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CarlnGebyte
 */
@RestController
@RequestMapping("/reservation/")
public class ReservationController {
    /**
     * Atributo servicio
     */
    private ReservationService service;

    /**
     * Constructor
     * @param service
     */
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    /**
     * Método para obtener todas las reservaciones
     * @return
     */
    @GetMapping("all")
    public List<Reservations> getAll() {
        return service.getAll();
    }

    /**
     * Método para crear una reservación
     * @param reservation
     * @return
     */
    @PostMapping("save")
    public Reservations save(@RequestBody Reservations reservation) {
        return service.save(reservation);
    }

    /**
     * Método para actualizar una reservación
     * @param reservation
     * @return
     */
    @PutMapping("update")
    public Reservations update(@RequestBody Reservations reservation) {
        return service.update(reservation);
    }

    /**
     * Método para eliminar una reservación
     * @param idReservation
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer idReservation) {
        service.delete(idReservation);
    }
}
