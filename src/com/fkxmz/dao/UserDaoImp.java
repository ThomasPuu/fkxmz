package com.fkxmz.dao;

import com.fkxmz.pojo.NewUser;

public class UserDaoImp extends BaseDao implements UserDao{

    @Override
    public NewUser queryUserByUsername(String username) {
        String sql = "select id,phone,username,password from user where username = ?";
        return queryForOne(NewUser.class,sql,username);
    }

    @Override
    public NewUser queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id phone,username,password from user where username = ? and password = ?";
        return queryForOne(NewUser.class,sql,username,password);
    }

    @Override
    public int saveUser(NewUser user) {
        String sql = "insert into user(phone,username,password) values(?,?,?)";
        return update(sql,user.getPhone(),user.getUsername(),user.getPassword());
    }
}
