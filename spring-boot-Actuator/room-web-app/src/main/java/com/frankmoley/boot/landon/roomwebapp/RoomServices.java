package com.frankmoley.boot.landon.roomwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServices  implements HealthIndicator {
    private RoomRepository roomRepository;

    @Autowired
    public RoomServices(RoomRepository roomRepository){
        super();
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        List<Room> rooms = new ArrayList<>();
        this.roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    @Override
    public Health health() {
        List<Room> allRooms = getAllRooms();
        if(allRooms.size() >0){
            return Health.up().build();
        }
        return Health.down().build();
    }
}
