package com.sjxy.service;

import com.sjxy.domain.User;

public interface UserService {
    User login(String username, String password);
}
