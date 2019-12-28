package com.frankmoley.boot.landon.roomwebapp.repository;

import com.frankmoley.boot.landon.roomwebapp.Entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository<Room,Long> {
}
