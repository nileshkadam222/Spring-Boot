package com.hoffnung.departmentservice.service;

import com.hoffnung.departmentservice.entity.Department;
import com.hoffnung.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
       log.info("Inside Department service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
