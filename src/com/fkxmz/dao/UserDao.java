package com.fkxmz.dao;
import com.fkxmz.pojo.NewUser;

public interface UserDao {
    //根据用户名查询用户信息
    public NewUser queryUserByUsername(String username);

    //根据用户名和密码查询用户信息
    public NewUser queryUserByUsernameAndPassword(String username,String password);

    //保存用户信息
    public int saveUser(NewUser user);
}
