package com.example.fileservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenericSqlExecutor {

    private final JdbcTemplate template;

    @Value("${fileimport.sql}")
    private String sql;

    public void executeSql(String sql, Object[] values) {
        template.update(sql, values);
    }
}
