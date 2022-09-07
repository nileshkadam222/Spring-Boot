package com.study.point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.point.entities.Teacher;
import com.study.point.repositories.TeacherRepository;

/**
 * Product service implement.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private TeacherService teacherService;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @Autowired
    public void setTeacherService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

     @Override
    public Iterable<Teacher> listAllTeachers() {
        return teacherRepository.findAll();
    }
	
    @Override
    public Teacher getTeacherById(Integer id) {
        Teacher teacher=teacherRepository.findById(id).orElse(null);
		return teacher;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }
	

}
