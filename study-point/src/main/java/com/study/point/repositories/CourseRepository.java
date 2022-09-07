package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    
    List<Course> findByName(String name);
    
}
