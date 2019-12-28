package com.frankmoley.boot.landon.roomwebapp.web;

import com.frankmoley.boot.landon.roomwebapp.Entity.Room;
import com.frankmoley.boot.landon.roomwebapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private RoomService roomServices;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomServices.getAllRooms();
    }
}
