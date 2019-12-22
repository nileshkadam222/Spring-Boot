package com.worddocumentdownloader.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface WordDocumentCreatorRepo{
    public List<Map<String, Object>> executeQuery(String sqlQuery, Map<String,Object> params);

}
