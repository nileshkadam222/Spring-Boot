package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    
    List<Report> findByName(String name); 
    
}
