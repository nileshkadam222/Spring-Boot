package com.frankmoley.boot.landon.roomwebapp.service;

import com.frankmoley.boot.landon.roomwebapp.Entity.Room;
import com.frankmoley.boot.landon.roomwebapp.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepo roomRepo;

    @Override
    public List<Room> getAllRooms()
    {
       List<Room> rooms = new ArrayList<Room>();
       roomRepo.findAll().forEach(rooms::add);
       return rooms;
    }
}
