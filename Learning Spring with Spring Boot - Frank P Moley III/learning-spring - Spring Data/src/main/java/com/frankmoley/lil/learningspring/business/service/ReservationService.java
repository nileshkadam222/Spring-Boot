package com.frankmoley.lil.learningspring.business.service;

import com.frankmoley.lil.learningspring.business.domain.RoomReservation;
import com.frankmoley.lil.learningspring.data.entity.Guest;
import com.frankmoley.lil.learningspring.data.entity.Reservation;
import com.frankmoley.lil.learningspring.data.entity.Room;
import com.frankmoley.lil.learningspring.data.repository.GuestRepository;
import com.frankmoley.lil.learningspring.data.repository.ReservationRepository;
import com.frankmoley.lil.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private  final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(java.util.Date date){
        Iterable<Room>  rooms = roomRepository.findAll();
        Map<Long,RoomReservation> roomReservationMap = new HashMap<Long,RoomReservation>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setName(room.getName());
            roomReservationMap.put(room.getRoomId(),roomReservation);
        });

        Iterable<Reservation> reservations = reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });

        List<RoomReservation> roomReservationsList = new ArrayList<RoomReservation>();
        for(Long key : roomReservationMap.keySet()){
            roomReservationsList.add(roomReservationMap.get(key));
        }

        roomReservationsList.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getName() == o2.getName()){
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        return roomReservationsList;
    }
}
