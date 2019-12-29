package com.frankmoley.boot.landon.roomwebapp;

import com.frankmoley.landon.aop.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private RoomServices roomServices;

    @Autowired
    private CounterService counterService;

    @Autowired
    public ApiController(RoomServices roomServices){
        super();
        this.roomServices = roomServices;
    }

    @GetMapping("/rooms")
    @Timed
    public List<Room> getAllRooms(){
        counterService.increment("Room service invokedl");
        return this.roomServices.getAllRooms();
    }
}
