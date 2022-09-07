package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    
    List<Teacher> findByName(String teach_id);
    
}
