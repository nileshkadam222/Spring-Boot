package com.study.point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.point.entities.Reportlist;
import com.study.point.repositories.ReportlistRepository;

/**
 * Product service implement.
 */
@Service
public class ReportlistServiceImp implements ReportlistService {

    private ReportlistRepository reportlistRepository;

    @Autowired
    public void setReportlistRepository(ReportlistRepository reportlistRepository) {
        this.reportlistRepository = reportlistRepository;
    }

     @Override
    public Iterable<Reportlist> listAllReportlists() {
        return reportlistRepository.findAll();
    }
	

}
