package com.worddocumentdownloader.wordDocumentConfiguration;

public class WordExportProperties {
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