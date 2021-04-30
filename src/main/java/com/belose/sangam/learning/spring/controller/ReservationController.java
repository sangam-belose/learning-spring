/*
package com.belose.sangam.learning.spring.controller;*/
package com.belose.sangam.learning.spring.controller;

import com.belose.sangam.learning.spring.business.domain.RoomReservation;
import com.belose.sangam.learning.spring.data.entity.Reservation;
import com.belose.sangam.learning.spring.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable("reservationId") long reservationId) {
        return reservationRepository.findById(reservationId).get();
    }
}

