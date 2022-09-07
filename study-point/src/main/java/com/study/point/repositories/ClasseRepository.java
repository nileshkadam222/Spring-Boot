package com.study.point.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.point.entities.Classe;

@Repository
public interface ClasseRepository extends CrudRepository<Classe, Long> {

    List<Classe> findByName(String name);

}
