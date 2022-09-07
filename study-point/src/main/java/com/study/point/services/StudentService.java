package com.study.point.services;

import com.study.point.entities.Student;

public interface StudentService {

//    /*  Iterable<Product> listAllProducts(); */

    Student getStudentById(Integer id);

    Student saveStudent(Student student);

    void deleteStudent(Integer id);

	Iterable<Student> listAllStudents();

}
