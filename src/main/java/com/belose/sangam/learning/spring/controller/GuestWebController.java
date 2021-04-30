package com.belose.sangam.learning.spring.controller;

import com.belose.sangam.learning.spring.business.service.GuestService;
import com.belose.sangam.learning.spring.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/webguests")
public class GuestWebController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public String getGuests(Model model) {
        List<Guest> guests = this.guestService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
