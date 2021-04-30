/*
package com.belose.sangam.learning.spring.controller;*/
package com.belose.sangam.learning.spring.controller;

import com.belose.sangam.learning.spring.data.entity.Room;
import com.belose.sangam.learning.spring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{roomId}")
    public Room getRoom(@PathVariable("roomId") Long roomId) {
        return roomRepository.findById(roomId).get();
    }
}

