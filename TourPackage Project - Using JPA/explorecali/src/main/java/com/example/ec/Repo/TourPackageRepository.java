package com.example.ec.Repo;

import com.example.ec.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

public interface TourPackageRepository extends CrudRepository<TourPackage,String> {

    TourPackage findByName(String name);
}

