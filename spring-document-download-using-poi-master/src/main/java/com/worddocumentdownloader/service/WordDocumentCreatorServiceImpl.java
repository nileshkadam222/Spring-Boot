package com.worddocumentdownloader.service;

import com.worddocumentdownloader.repository.WordDocumentCreatorRepo;
import com.worddocumentdownloader.wordDocumentConfiguration.DocumentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordDocumentCreatorServiceImpl implements WordDocumentCreatorService{
    @Autowired
    private WordDocumentCreatorRepo wordDocumentCreatorRepo;

    @Autowired
    private DocumentProperties prop;
    @Override
    public String generateWordDocument(){
        List<DocumentProperties.WordExportProperties> docexportproperties = prop.getDocexportproperties();
        System.out.println(docexportproperties);
        return docexportproperties.toString();
    }
}

