package com.worddocumentdownloader.web;

import com.worddocumentdownloader.service.WordDocumentCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordDocumentCreatorController {
    @Autowired
    private  WordDocumentCreatorService wordDocumentCreatorService;

    @GetMapping("/generateWordDocument")
    public String generateWordDocument(){
        return wordDocumentCreatorService.generateWordDocument();
    }

}
