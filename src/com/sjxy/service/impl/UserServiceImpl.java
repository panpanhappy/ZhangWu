package com.sjxy.service.impl;

import com.sjxy.dao.UserDao;
import com.sjxy.dao.impl.UserDaoImpl;
import com.sjxy.domain.User;
import com.sjxy.service.UserService;

/*
  service中调用dao中方法，完成功能
  所以在service成员的位置创建dao实现类的对象
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}


