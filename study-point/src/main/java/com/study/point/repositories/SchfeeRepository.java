package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Schfee;

@Repository
public interface SchfeeRepository extends CrudRepository<Schfee, Long> {
    
    List<Schfee> findByName(String name);
    
}
