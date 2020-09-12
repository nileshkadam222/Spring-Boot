package com.frankmoley.lil.learningspring.data.repository;

import com.frankmoley.lil.learningspring.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest,Long> {
}
