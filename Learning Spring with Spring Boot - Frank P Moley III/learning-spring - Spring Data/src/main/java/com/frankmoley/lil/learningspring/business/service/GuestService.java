package com.frankmoley.lil.learningspring.business.service;

import com.frankmoley.lil.learningspring.business.domain.RoomReservation;
import com.frankmoley.lil.learningspring.data.entity.Guest;
import com.frankmoley.lil.learningspring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getHotelGuest(){
       Iterable<Guest> guests = this.guestRepository.findAll();
       List<Guest> guestList = new ArrayList<Guest>();
       guests.forEach(guest -> guestList.add(guest));
        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if (o1.getFirstName() == o2.getFirstName()){
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });

        return guestList;
    }
}
