package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
    
    List<Notice> findByName(String name);
    
}
