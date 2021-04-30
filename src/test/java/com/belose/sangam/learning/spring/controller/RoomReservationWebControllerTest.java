package com.belose.sangam.learning.spring.controller;

import com.belose.sangam.learning.spring.business.domain.RoomReservation;
import com.belose.sangam.learning.spring.business.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomReservationWebControllerTest {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetReservations() throws Exception {
        String dateString = "2021-04-30";
        Date date = DateUtils.createDateFromDateString(dateString);
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setGuestId(1);
        roomReservation.setFirstName("Sangam");
        roomReservation.setLastName("Belose");
        roomReservation.setDate(date);
        roomReservation.setRoomId(10);
        roomReservation.setRoomNumber("20340");
        roomReservation.setRoomName("roomName");

        List<RoomReservation> roomReservationList = new ArrayList<>();
        roomReservationList.add(roomReservation);

        given(reservationService.getRoomReservations(date)).willReturn(roomReservationList);

        this.mockMvc
                .perform(get("/roomreservations?date=" + dateString))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Belose, Sangam")));
    }
}
