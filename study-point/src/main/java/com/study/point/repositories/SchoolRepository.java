package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.School;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    
    List<School> findByName(String name);
    
}
