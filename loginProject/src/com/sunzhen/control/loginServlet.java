package com.sunzhen.control;

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
        //设置编码格式:
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

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
//            response.getWriter().write("success");
            /*请求转发
            request.getRequestDispatcher("hello").forward(request,response);*/
            //重定向:为了避免表单重复提交  例如银行转账
            response.sendRedirect("hello");
        }else {
//            response.getWriter().write("failure");   通常我们这样做 更多的是重新回到登陆窗口

            /*response.setContentType("text/html");
            //获取响应的输出流
            PrintWriter out = response.getWriter();
            out.write("<html>");
            out.write("<head>");
            out.write("</head>");
            out.write("<body>");
            out.write("<form action='login' method='get'>");
            out.write("user: <input type='text' name='name' value=''><br/>" );
            out.write("pwd: <input type='pwd' name='pwd' value=''><br/>");
            out.write("<input type='submit' value='login'>");
            out.write("</form>");
            out.write("</body>");
            out.write("</html>");*/
            //设置参数 :必须设置编码格式
            request.setAttribute("str","用户名或密码错误");

            //请求servlet的时候需要写相对路径;同时不需要后续代码的处理;
            request.getRequestDispatcher("page").forward(request,response);
            return;
        }
    }
}
