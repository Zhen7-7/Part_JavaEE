package com.sunzhen.Service.impl;

import com.sunzhen.Dao.UserDao;
import com.sunzhen.Dao.impl.UserDaoImpl;
import com.sunzhen.Service.UserService;
import com.sunzhen.entity.User;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
