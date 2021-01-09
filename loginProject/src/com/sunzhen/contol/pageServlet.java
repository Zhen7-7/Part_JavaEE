package com.sunzhen.contol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "pageServlet")
public class pageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到用户请求,返回相应的登录页面");
        //获取返回的输出流对象:
        PrintWriter out = response.getWriter();
        //设置相应编码:

        //这些标签需要我们 手写写到out 里面
        //response 返回的数据有各种格式 jsp html
        response.setContentType("text/html");//最好这是这个去更准确的解析
        out.write("<html>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");
        out.write("<form action='login' method='get'>");
        out.write("username: <input type='text' name='name' value=''><br/>" );
        out.write("password: <input type='pwd' name='pwd' value=''><br/>");
        out.write("<input type='submit' value='login'>");
        out.write("</form>");
        out.write("</body>");
        out.write("</html>");
    }
}
