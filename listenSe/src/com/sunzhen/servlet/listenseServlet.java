package com.sunzhen.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "listenseServlet")
public class listenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        System.out.println("listenServlet逻辑处理");
//        request.setAttribute("listense","listense");
//        request.removeAttribute("listense");
        //向servletContext中添加属性值:
        ServletContext  sc= this.getServletContext();
        sc.setAttribute("servletcontext","servletcontext_value");



        response.getWriter().write("listense study");
    }
}
