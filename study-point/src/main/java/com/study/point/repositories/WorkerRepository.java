package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Worker;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    
    List<Worker> findById(String name);
    
}
