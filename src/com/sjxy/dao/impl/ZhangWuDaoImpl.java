package com.sjxy.dao.impl;

import com.sjxy.dao.ZhangWuDao;
import com.sjxy.domain.ZhangWu;
import com.sjxy.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZhangWuDaoImpl implements ZhangWuDao {
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    ZhangWu zhangWu = null;
    PreparedStatement preparedStatement = null;

    //根据账务号查询账务
    @Override
    public ZhangWu getZhangWuById(int id) throws SQLException {
        try {
            // 通过JDBC获取数据库连接，并执行SQL查询操作
            connection = JDBCUtil.getConnection();
            // 编写SQL语句
            String sql = "SELECT * FROM zhangwu WHERE zwid = ?";
            // 使用PreparedStatement防止SQL注入，并设置参数
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);//参考
            // 执行查询
            rs = preparedStatement.executeQuery();
            // 检查是否有结果,遍历结果集
            if (rs.next()) {
                zhangWu = new ZhangWu();
                zhangWu.setZwid(rs.getInt("zwid"));
                zhangWu.setFlname(rs.getString("flname"));
                zhangWu.setMoney(rs.getDouble("money"));
                zhangWu.setZhangHu(rs.getString("zhanghu"));
                zhangWu.setCreatetime(String.valueOf(rs.getDate("createtime")));
                zhangWu.setDescription(rs.getString("description"));
            }
        } finally {
            // 关闭资源
            JDBCUtil.close(connection, statement, rs);
        }
        return zhangWu; // 可能返回null，如果没有找到对应的ID

    }

    //展示所有账务
    @Override
    public List<ZhangWu> getAllZhangWu() throws SQLException {
        List<ZhangWu> list = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM zhangwu";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                ZhangWu zhangWu = new ZhangWu();
                zhangWu.setZwid(rs.getInt("zwid"));
                zhangWu.setFlname(rs.getString("flname"));
                zhangWu.setMoney(rs.getDouble("money"));
                zhangWu.setZhangHu(rs.getString("zhanghu"));
                zhangWu.setCreatetime(String.valueOf(rs.getDate("createtime")));
                zhangWu.setDescription(rs.getString("description"));
                list.add(zhangWu);
            }
        } finally {
            // 关闭资源
            JDBCUtil.close(connection, statement, rs);
        }

        return list;
    }

    @Override
    public void deleteZhangWu(int id) throws SQLException {

        try {
            connection = JDBCUtil.getConnection();
            // 编写SQL语句
            String sql = "DELETE FROM zhangwu WHERE zwid = ?";
            preparedStatement = connection.prepareStatement(sql);
            // 设置占位符的值
            preparedStatement.setInt(1, id);

            // 执行更新操作
            int Rows = preparedStatement.executeUpdate();
            // 可以根据Rows的值来判断是否成功删除了记录
            if (Rows > 0) {
                // 删除了记录
                System.out.println("成功删除了ID为" + id + "的账务信息。");
            } else {
                // 没有找到对应的记录进行删除
                System.out.println("没有找到ID为" + id + "的账务信息进行删除。");
            }

        } finally {
            // 关闭资源
            JDBCUtil.close(connection, preparedStatement);

        }

    }

    @Override
    public void modifyZhangWu(int id) throws SQLException {

        String sql = "UPDATE zhangwu SET flname = ?, money = ?, zhanghu = ?, " +
                "createtime = ?, description = ? WHERE zwid = ?";

        connection = JDBCUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, zhangWu.getFlname());
        preparedStatement.setDouble(2, zhangWu.getMoney());
        preparedStatement.setString(3, zhangWu.getZhangHu());
        preparedStatement.setString(4, zhangWu.getCreatetime());
        preparedStatement.setString(5, zhangWu.getDescription());
        preparedStatement.setInt(6, zhangWu.getZwid());

        int Rows = preparedStatement.executeUpdate();
        if (Rows > 0) {
            // 删除了记录
            System.out.println("修改成功。");
        } else {
            // 没有找到对应的记录进行删除
            System.out.println("修改失败。");
        }
        JDBCUtil.close(connection, preparedStatement);

    }

    @Override
    public void addZhangWu(ZhangWu zhangWu) throws SQLException {
        String sql = "INSERT INTO zhangwu (flname, money, zhanghu, createtime, description) VALUES (?, ?, ?, ?, ?)";

        connection = JDBCUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, zhangWu.getFlname());
        preparedStatement.setDouble(2, zhangWu.getMoney());
        preparedStatement.setString(3, zhangWu.getZhangHu());
        preparedStatement.setString(4, zhangWu.getCreatetime());
        preparedStatement.setString(5, zhangWu.getDescription());

        int Rows = preparedStatement.executeUpdate();
        if (Rows > 0) {
            // 删除了记录
            System.out.println("修改成功。");
        } else {
            // 没有找到对应的记录进行删除
            System.out.println("修改失败。");
        }
        JDBCUtil.close(connection, preparedStatement);


    }
}
