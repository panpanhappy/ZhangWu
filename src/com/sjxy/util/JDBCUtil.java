package com.sjxy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource dataSource ;
    static {
        try {
            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pro = new Properties();
            pro.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 提供获取连接池的方法
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 获取Connection连接方法
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection conn, Statement stat){
        //关闭之前判断对象是否为空
        if (conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        if (stat!=null){
            try{
                stat.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, Statement stat, ResultSet rs) {
        //关闭之前判断对象是否为空
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
