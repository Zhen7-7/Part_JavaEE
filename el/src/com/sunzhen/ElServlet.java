package com.sunzhen;

import com.sunzhen.entity.Address;
import com.sunzhen.entity.User;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ElServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从请求中获取数据:
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        //给request对象单独设置属性:
        request.setAttribute("aa","aaaaaaa");

        //给request添加对象
        User user = new User(1, "莫玉丹", new Address("黑龙江", "齐齐哈尔", "克山县"));
        User user1 = new User(2,"孙朕",new Address("黑龙江","哈尔滨","香坊区"));

        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        request.setAttribute("user",user);

        //给request对象设置集合:
        request.setAttribute("list",list);

        //通过某一个请求转发的方式跳转到jsp页面
        request.getRequestDispatcher("el.jsp").forward(request,response);

    }
}
