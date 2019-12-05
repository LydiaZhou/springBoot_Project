package com.practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private final static String userCheckQuery = "SELECT count(*) FROM t_user WHERE username =? and password = ?";
    private final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user  " +
            " WHERE user_name =? and password=? ";
    boolean userIndicator = false;

    public boolean userCheck(String userName, String password) {
        jdbcTemplate.query(userCheckQuery,new Object[]{userName, password},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        if (rs.getInt(1) > 0) {
                            userIndicator = true;
                        } else {
                            userIndicator = false;
                        }
                    }
                });
        return userIndicator;
    }

    public int getMatchCount(String userName, String password) {

        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
