package com.example.ec.service;

import com.example.ec.Repo.TourPackageRepository;
import com.example.ec.Repo.TourRepository;
import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import com.example.ec.domain.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;

public class TourService {
    @Autowired
    TourRepository tourRepository;

    @Autowired
    TourPackageRepository tourPackageRepository;

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region){
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if(tourPackage != null){
            throw new RuntimeException("Tour Package Does Not exist "+ tourPackageName);
        }
        return tourRepository.save(new Tour(title,description,blurb,price,duration,bullets,keywords,tourPackage,difficulty,region));
    }

    public Iterable<Tour> lookup(){
        return tourRepository.findAll();
    }

    public long totalCount(){
        return tourRepository.count();
    }
}
