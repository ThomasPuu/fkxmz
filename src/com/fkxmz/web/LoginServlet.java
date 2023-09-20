package com.fkxmz.web;

import com.fkxmz.pojo.NewUser;
import com.fkxmz.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserServiceImp userServiceImp = new UserServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        NewUser newUser = userServiceImp.login(new NewUser(null,username,password));
        if (newUser == null){
            System.out.println("输入账号或密码错误！");
            req.getRequestDispatcher("/副页/登录.html").forward(req,resp);
        }else {
            System.out.println("登录成功！");
            req.getRequestDispatcher("/副页/用户信息.html").forward(req,resp);
        }
    }
}
