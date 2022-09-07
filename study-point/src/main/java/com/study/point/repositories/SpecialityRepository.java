package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Speciality;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
    
    List<Speciality> findByName(String name);
    
}
