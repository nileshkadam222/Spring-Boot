package com.example.roomClrApp.configuration;

import com.example.roomClrApp.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RoomCleningPrimer implements CommandLineRunner {


    RestTemplate restTemplate;
    RoomCleningPrimer(){
        super();
        this.restTemplate = new RestTemplate();
    }
    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:8080/rooms";
        Room[] roomArray = restTemplate.getForObject(url,Room[].class);
        List<Room> roomList = Arrays.asList(roomArray);
        System.out.println("Room List " + roomList);
    }
}
