package com.hoffnung.departmentservice.controller;

import com.hoffnung.departmentservice.entity.Department;
import com.hoffnung.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Lob;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody  Department department){
        log.info("Inside SaveDepartment Controller");
        return  departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("inside findDepartmnetByiD METHOD OF DepartmentController");
        return departmentService.findDepartmentById(departmentId);

    }
}
