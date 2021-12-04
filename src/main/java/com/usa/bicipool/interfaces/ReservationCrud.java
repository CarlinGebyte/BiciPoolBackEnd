package com.usa.bicipool.interfaces;

import com.usa.bicipool.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationCrud extends JpaRepository<Reservations, Integer> {
}
