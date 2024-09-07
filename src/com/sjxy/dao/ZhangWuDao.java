package com.sjxy.dao;

import com.sjxy.domain.ZhangWu;

import java.sql.SQLException;
import java.util.List;

public interface ZhangWuDao {
    public ZhangWu getZhangWuById(int id) throws SQLException;


    public List<ZhangWu> getAllZhangWu() throws SQLException;

    public void deleteZhangWu(int id) throws SQLException;

    public void modifyZhangWu(int id) throws SQLException;

    public void addZhangWu(ZhangWu zhangWu) throws SQLException;
}