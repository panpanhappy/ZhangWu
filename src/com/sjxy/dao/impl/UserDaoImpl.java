package com.sjxy.dao.impl;

import com.sjxy.dao.UserDao;
import com.sjxy.domain.User;
import com.sjxy.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao 接口的实现类，用于处理用户相关的数据库操作。
 */
public class UserDaoImpl implements UserDao {

    // 使用 JdbcTemplate 简化 JDBC 操作，数据源通过 JDBCUtil 获取
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    
    @Override
    public User login(String username, String password) {
        String sql = "SELECT * FROM zw_user WHERE username = ? AND password = ?";
        // 使用 queryForObject 方法执行查询，并通过 RowMapper 将结果集映射为 User 对象
        return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                // 映射 ResultSet 的一行为 User 对象
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        });
    }
}