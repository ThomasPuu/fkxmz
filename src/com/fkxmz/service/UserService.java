package com.fkxmz.service;
import com.fkxmz.pojo.NewUser;
public interface UserService {
    //注册用户
    public void registerUser(NewUser user);

    //登录
    public NewUser login(NewUser user);

    //检查用户名是否可用
    public boolean existsUsername(String username);
}
