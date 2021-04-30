
package com.belose.sangam.learning.spring.controller;

import com.belose.sangam.learning.spring.data.entity.Guest;
import com.belose.sangam.learning.spring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
}


