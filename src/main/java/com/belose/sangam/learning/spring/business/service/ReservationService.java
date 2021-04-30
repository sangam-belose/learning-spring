package com.belose.sangam.learning.spring.business.service;

import com.belose.sangam.learning.spring.business.domain.RoomReservation;
import com.belose.sangam.learning.spring.data.entity.Guest;
import com.belose.sangam.learning.spring.data.entity.Reservation;
import com.belose.sangam.learning.spring.data.entity.Room;
import com.belose.sangam.learning.spring.data.repository.GuestRepository;
import com.belose.sangam.learning.spring.data.repository.ReservationRepository;
import com.belose.sangam.learning.spring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservations(Date date) {
        List<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = rooms.stream()
                .collect(Collectors.toMap(room -> room.getRoomId(), room -> {
                    RoomReservation roomReservation = new RoomReservation();
                    roomReservation.setRoomId(room.getRoomId());
                    roomReservation.setRoomName(room.getName());
                    roomReservation.setRoomNumber(room.getRoomNumber());
                    return roomReservation;
                }));

        List<Reservation> reservationList = this.reservationRepository
                .findAllByReservationDate(new java.sql.Date(date.getTime()));

        reservationList.stream().forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setGuestId(guest.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        return roomReservations;

    }
}
