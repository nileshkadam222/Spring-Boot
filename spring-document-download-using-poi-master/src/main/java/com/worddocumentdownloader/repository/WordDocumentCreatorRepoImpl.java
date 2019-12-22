package com.worddocumentdownloader.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WordDocumentCreatorRepoImpl implements WordDocumentCreatorRepo{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Map<String, Object>> executeQuery(String sqlQuery, Map<String,Object> params){
        return namedParameterJdbcTemplate.queryForList(sqlQuery, params);
    }
}
