package com.fkxmz.web;

import com.fkxmz.pojo.NewUser;

import com.fkxmz.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    UserServiceImp userServiceImp = new UserServiceImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取请求参数
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String agpassword = req.getParameter("agpassword");
        //检验
        if (userServiceImp.existsUsername(username)){
            System.out.println("用户名已存在！");
            req.getRequestDispatcher("/副页/登录.html").forward(req,resp);
        }else if (password.equals(agpassword)){
            System.out.println("成功注册！");
            userServiceImp.registerUser(new NewUser(phone,username,password));
            req.getRequestDispatcher("/副页/登录.html").forward(req,resp);
        }else {
            System.out.println("两次密码不相同！");
            req.getRequestDispatcher("/副页/登录.html").forward(req,resp);
        }
    }
}
