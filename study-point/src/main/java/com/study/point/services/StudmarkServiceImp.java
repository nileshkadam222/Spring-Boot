package com.study.point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.point.entities.Studmark;
import com.study.point.repositories.StudmarkRepository;

/**
 * Student Marks service implement.
 */
@Service
public class StudmarkServiceImp implements StudmarkService {

    private StudmarkRepository studmarkRepository;
    private StudmarkService studmarkService;

    @Autowired
    public void setStudmarkRepository(StudmarkRepository studmarkRepository) {
        this.studmarkRepository = studmarkRepository;
    }
    @Autowired
    public void setStudmarkService(StudmarkService studmarkService){
        this.studmarkService = studmarkService;
    }

     @Override
    public Iterable<Studmark> listAllStudmarks() {
        return studmarkRepository.findAll();
    }
	
    @Override
    public Studmark getStudmarkById(Integer id) {
        Studmark studmark = studmarkRepository.findById(id).orElse(null);
		return studmark;
    }

    @Override
    public Studmark saveStudmark(Studmark studmark) {
        return studmarkRepository.save(studmark);
    }

    @Override
    public void deleteStudmark(Integer id) {
        studmarkRepository.deleteById(id);
    }
	

}
