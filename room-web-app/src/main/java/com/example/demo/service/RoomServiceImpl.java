package com.example.demo.service;

import com.example.demo.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private static List<Room> rooms = new ArrayList<Room>();
    static {
        for(int i=0;i<10;i++){
            rooms.add(new Room(i,"Room "+i,"R "+i,"Q"));
        }
    }

    @Override
    public List<Room> getAllRooms(){
        return rooms;
    }
}
