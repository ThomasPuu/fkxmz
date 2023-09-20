package com.fkxmz.service;

import com.fkxmz.dao.UserDao;
import com.fkxmz.dao.UserDaoImp;
import com.fkxmz.pojo.NewUser;

public class UserServiceImp implements UserService{
    private UserDao userDao = new UserDaoImp();
    @Override
    public void registerUser(NewUser user) {
        userDao.saveUser(user);
    }
    @Override
    public NewUser login(NewUser user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}

