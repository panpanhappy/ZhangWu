package com.sjxy.service;

import com.sjxy.domain.ZhangWu;

import java.sql.SQLException;
import java.util.List;


/**
 * 账务服务接口，包含对账务信息的基本操作。
 */
public interface ZhangWuService {

    /**
     * 根据ID获取账务信息。
     * @param id 账务ID
     * @return 对应的ZhangWu对象，或null（如果不存在）
     * @throws SQLException 如果数据库查询出错
     */
    ZhangWu getZhangWuById(int id) throws SQLException;

    /**
     * 获取所有账务信息。
     * @return 账务信息列表
     * @throws SQLException 如果数据库查询出错
     */
    List<ZhangWu> getAllZhangWu() throws SQLException;
    /**
     * 删除指定ID的账务信息。
     * @param id 账务ID
     * @throws SQLException 如果数据库删除出错
     */
    void deleteZhangWu(int id) throws SQLException;

    /**
     * 修改指定ID的账务信息（具体修改逻辑由实现类定义）。
     * @param id 账务ID
     * @throws SQLException 如果数据库更新出错
     */
    void modifyZhangWu(int id) throws SQLException;

    /**
     * 添加新的账务信息。
     * @param zhangWu 新的账务信息对象
     * @throws SQLException 如果数据库插入出错
     */
    void addZhangWu(ZhangWu zhangWu) throws SQLException;
}