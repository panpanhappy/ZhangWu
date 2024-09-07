package com.sjxy.service.impl;

import com.sjxy.dao.ZhangWuDao;
import com.sjxy.dao.impl.ZhangWuDaoImpl;
import com.sjxy.domain.ZhangWu;
import com.sjxy.service.ZhangWuService;

import java.sql.SQLException;
import java.util.List;

public class ZhangwuServiceImpl implements ZhangWuService {

    ZhangWuDao zhangwuDao=new ZhangWuDaoImpl();


    @Override
    public ZhangWu getZhangWuById(int id) throws SQLException {
        return zhangwuDao.getZhangWuById(id);
    }

    @Override

    public List<ZhangWu> getAllZhangWu() throws SQLException {
        return zhangwuDao.getAllZhangWu();
    }



    @Override
    public void deleteZhangWu(int id) throws SQLException {
        zhangwuDao.deleteZhangWu(id);
    }

    @Override
    public void modifyZhangWu(int id) throws SQLException {

        zhangwuDao.modifyZhangWu(id);
    }

    @Override
    public void addZhangWu(ZhangWu zhangWu) throws SQLException {

        zhangwuDao.addZhangWu(zhangWu);
    }


}
