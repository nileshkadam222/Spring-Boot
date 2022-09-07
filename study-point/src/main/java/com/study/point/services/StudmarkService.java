package com.study.point.services;

import com.study.point.entities.Studmark;

public interface StudmarkService {

   /*  Iterable<Product> listAllProducts(); */

    Studmark getStudmarkById(Integer id);

    Studmark saveStudmark(Studmark studmark);

    void deleteStudmark(Integer id);

	Iterable<Studmark> listAllStudmarks();

}
