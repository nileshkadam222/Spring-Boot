package com.study.point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.point.entities.Speciality;
import com.study.point.repositories.SpecialityRepository;

/**
 * Product service implement.
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {

    private SpecialityRepository specialityRepository;

    @Autowired
    public void setSpecialityRepository(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Iterable<Speciality> listAllSpecialitys() {
        return specialityRepository.findAll();
    }
	

}
