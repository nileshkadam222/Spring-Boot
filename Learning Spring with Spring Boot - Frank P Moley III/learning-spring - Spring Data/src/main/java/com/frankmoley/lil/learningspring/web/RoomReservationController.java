package com.frankmoley.lil.learningspring.web;

import com.frankmoley.lil.learningspring.business.domain.RoomReservation;
import com.frankmoley.lil.learningspring.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    @Autowired
    private ReservationService reservationService;


    @GetMapping
    public String getReservations(@RequestParam(value = "date",required = false)String date, Model model){
        List<RoomReservation> roomReservations = reservationService.getRoomReservationForDate(DateUtils.createDateFromDateString(date));
        model.addAttribute("roomReservations",roomReservations);
        return  "reservations";
    }
}
