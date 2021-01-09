package com.sunzhen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;


public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post请求");
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET请求");
        //获得请求行信息:
        String method = request.getMethod();
        System.out.println(method);

        //获取请求的完整地址:
        StringBuffer url = request.getRequestURL();
        System.out.println(url);
        //获取请求中的资源路径:
        String uri = request.getRequestURI();
        System.out.println(uri);
        //获取请求中的协议
        String schema = request.getScheme();
        System.out.println(schema);


        //获得请求头的信息:
        //因为是键值对  可以根据key去获得value的值
        String userAgent = request.getHeader("user-Agent");
        System.out.println(userAgent);
        
        
        //获得请求头中的key的所有枚举对象:
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            //得到的是所有的请求头的key对象 我们可以调用getHeader() 方法去得到值
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            //System.out.println(headerNames.nextElement());
            System.out.println(key+":"+value);
        }
        //获取用户请求数据:
        //无论请求时get还是post 获取请求的方式不变
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        //String fav = request.getParameter("fav");单个name多个值就不能用getParameter



        //获取用户中的所有key:
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String pkey = parameterNames.nextElement();
            String pvalue = request.getParameter(pkey);
            System.out.println(pkey+":"+pvalue);
        }
        
        //获取相同key的多个数据值 例如checkbox
        String[] favs = request.getParameterValues("fav");
        for(String str0:favs){
            System.out.println("fav"+":"+str0);
            System.out.println(name+":"+pwd+":"+str0);
        }



    }
}
