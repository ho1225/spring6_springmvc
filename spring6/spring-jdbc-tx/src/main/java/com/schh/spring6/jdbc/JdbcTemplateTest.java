package com.schh.spring6.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        // add

        //1. write sql
        String sql = "insert into t_emp values (null, ?, ?, ?)";
        //2. use jdbcTemplate method with argument
        int rows = jdbcTemplate.update(sql, "Amy", 20, "F");
        System.out.println(rows);
    }
}
