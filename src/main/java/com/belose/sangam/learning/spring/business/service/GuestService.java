package com.belose.sangam.learning.spring.business.service;

import com.belose.sangam.learning.spring.data.entity.Guest;
import com.belose.sangam.learning.spring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        List<Guest> guestList = guestRepository.findAll();
        guestList.sort(Comparator.comparing(Guest::getLastName));
        return guestList;
    }
}
