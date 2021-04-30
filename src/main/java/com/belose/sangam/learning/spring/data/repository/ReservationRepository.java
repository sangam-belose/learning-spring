package com.belose.sangam.learning.spring.data.repository;

import com.belose.sangam.learning.spring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByReservationDate(java.sql.Date date);
}
