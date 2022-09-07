package com.study.point.services;

import com.study.point.entities.School;

public interface SchoolService {

   /*  Iterable<Product> listAllProducts(); */

    //Eleve16 getEleve16ByCodcli(String codcli);
    //Eleve16 saveEleve16(Eleve16 Eleve16);
    //void deleteStatus(Integer id);
	
	Iterable<School> listAllSchools();
	//List<School> listAllSchoolsList();
	School getSchoolById(long id);
}
