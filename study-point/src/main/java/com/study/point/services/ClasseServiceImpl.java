package com.study.point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.point.entities.Classe;
import com.study.point.repositories.ClasseRepository;

/**
 * Product service implement.
 */
@Service
public class ClasseServiceImpl implements ClasseService {

    private ClasseRepository classeRepository;

    @Autowired
    public void setClasseRepository(ClasseRepository classeRepository) {
	this.classeRepository = classeRepository;
    }

    @Override
    public Iterable<Classe> listAllClasses() {
	return classeRepository.findAll();
    }

}
