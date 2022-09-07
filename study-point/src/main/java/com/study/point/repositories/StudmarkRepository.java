package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Studmark;

@Repository
public interface StudmarkRepository extends CrudRepository<Studmark, Integer> {
    
    List<Studmark> findByName(String name);
    
}
