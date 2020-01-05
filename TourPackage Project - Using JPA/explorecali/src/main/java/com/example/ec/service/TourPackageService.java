package com.example.ec.service;

import com.example.ec.Repo.TourPackageRepository;
import com.example.ec.domain.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;

public class TourPackageService {

    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code,String name){
        if(!tourPackageRepository.exists(code)){
            tourPackageRepository.save(new TourPackage(code,name));
        }
        return null;
    }

    public Iterable<TourPackage> getAllTourPackages(){
        return tourPackageRepository.findAll();
    }
    public long totalCount(){
        return tourPackageRepository.count();
    }
}
