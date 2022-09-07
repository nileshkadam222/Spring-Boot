package com.study.point.services;

import com.study.point.entities.Schfee;

public interface SchfeeService {

    Iterable<Schfee> listAllSchfees();

    Schfee getSchfeeById(Integer id);

    Schfee saveSchfee(Schfee schfee);

    void deleteSchfee(Integer id);
	
}
