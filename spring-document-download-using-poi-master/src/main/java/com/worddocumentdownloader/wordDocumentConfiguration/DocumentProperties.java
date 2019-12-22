package com.worddocumentdownloader.wordDocumentConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("worddocuments") // prefix app, find app.* values
public class DocumentProperties {
    private List<WordExportProperties> docexportproperties = new ArrayList<>();
    public List<WordExportProperties> getDocexportproperties() {
        return docexportproperties;
    }
    public void setDocexportproperties(List<WordExportProperties> docexportproperties) {
        this.docexportproperties = docexportproperties;
    }

}

