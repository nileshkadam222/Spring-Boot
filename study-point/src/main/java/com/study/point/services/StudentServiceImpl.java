package com.study.point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.point.entities.Student;
import com.study.point.repositories.StudentRepository;

/**
 * Student service implement.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    ////private StudentService studentService;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // @Autowired
    // public void setStudentService(StudentService studentService){
    //     this.studentService = studentService;
    // }

     @Override
    public Iterable<Student> listAllStudents() {

        return studentRepository.findAll();
    }
    @Override
    public Student getStudentById(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
		return student;
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
