package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    
    List<Department> findByName(String name);
    
}
