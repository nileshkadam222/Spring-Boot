package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    
    List<Report> findByName(String name); 
    
}
