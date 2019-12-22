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

    public static class WordExportProperties {
        private String sql;
        private String title;
        private String printtype;
        private String headertype;
        //getters and setters

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrinttype() {
            return printtype;
        }

        public void setPrinttype(String printtype) {
            this.printtype = printtype;
        }

        public String getHeadertype() {
            return headertype;
        }

        public void setHeadertype(String headertype) {
            this.headertype = headertype;
        }
        @Override
        public String toString() {
            return "{" +
                    "sql='" + sql+ '\'' +
                    ", title='" + title + '\'' +
                    ", printtype='" + printtype + '\'' +
                    ", headertype='" + headertype + '\'' +
                    '}';
        }
    }
}

