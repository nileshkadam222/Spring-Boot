package com.worddocumentdownloader.service;

import com.worddocumentdownloader.repository.WordDocumentCreatorRepo;
import com.worddocumentdownloader.wordDocumentConfiguration.DocumentProperties;
import com.worddocumentdownloader.wordDocumentConfiguration.WordExportProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class WordDocumentCreatorServiceImpl implements WordDocumentCreatorService{
    @Autowired
    private WordDocumentCreatorRepo wordDocumentCreatorRepo;

    @Autowired
    private DocumentProperties prop;
    @Override
    public String generateWordDocument(){
        List<WordExportProperties> docexportproperties = prop.getDocexportproperties();
        Iterator it = docexportproperties.iterator();
        while (it.hasNext()){
            WordExportProperties properties = (WordExportProperties) it.next();
            String sqlQuery = properties.getSql();
            Map<String,Object> paramMap = new HashMap<String,Object>();
            List<Map<String, Object>> queryData = wordDocumentCreatorRepo.executeQuery(sqlQuery, paramMap);
            System.out.println(queryData);
        }
        System.out.println(docexportproperties);
        return docexportproperties.toString();
    }
}

