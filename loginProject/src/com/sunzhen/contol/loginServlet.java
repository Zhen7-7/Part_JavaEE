package com.sunzhen.contol;

import com.sunzhen.Service.UserService;
import com.sunzhen.Service.impl.UserServiceImpl;
import com.sunzhen.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        //封装对象:
        User user = new User(name, pwd);
        //调用Service 进行逻辑处理;
        User u = userService.checkUser(user);
        System.out.println(u);

        //响应
        if(u!=null){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("failure");
        }
    }
}
