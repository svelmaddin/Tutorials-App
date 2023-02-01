package com.example.JavaSpring.mapper;

import com.example.JavaSpring.model.Tutorial;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorialMapper implements RowMapper<Tutorial> {

    @Override
    public Tutorial mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tutorial tutorial = new Tutorial();
        tutorial.setId(rs.getLong("id"));
        tutorial.setTitle(rs.getString("title"));
        tutorial.setDescription(rs.getString("description"));
        tutorial.setPublished(false);
        return tutorial;
    }
}
