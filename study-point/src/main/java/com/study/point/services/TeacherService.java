package com.study.point.services;

import com.study.point.entities.Teacher;

public interface TeacherService {

   /*  Iterable<Product> listAllProducts(); */

     Teacher getTeacherById(Integer id);

     Teacher saveTeacher(Teacher teacher);

     void deleteTeacher(Integer id);
	
	Iterable<Teacher> listAllTeachers();
	
}
