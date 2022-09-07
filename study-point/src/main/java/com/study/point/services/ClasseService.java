package com.study.point.services;

import com.study.point.entities.Classe;
import com.study.point.repositories.ClasseRepository;

public interface ClasseService {

    Iterable<Classe> listAllClasses();

    void setClasseRepository(ClasseRepository classeRepository);

}
