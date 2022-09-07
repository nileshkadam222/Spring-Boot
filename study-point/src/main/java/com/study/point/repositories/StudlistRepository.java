package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Studlist;

@Repository
public interface StudlistRepository extends CrudRepository<Studlist, Long> {
    
    List<Studlist> findByName(String name);
    
}
