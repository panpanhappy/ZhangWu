package com.sjxy.dao;

import com.sjxy.domain.User;

public interface UserDao {
    User login(String username, String password);
}
