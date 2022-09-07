package com.study.point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.point.entities.Course;
import com.study.point.repositories.CourseRepository;

/**
 * Product service implement.
 */
@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

     @Override
    public Iterable<Course> listAllCourses() {
        return courseRepository.findAll();
    }
	

}
