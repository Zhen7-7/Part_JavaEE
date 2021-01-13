package com.sunzhen;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext:
 *      作用:
 *          解决不同用户的数据共享问题;
 *      特点:
 *          1.由服务器创建;
 *          2.所有用户共享ServletContext对象;
 *          3.所有的servlet都可以访问一个ServletContext中的属性;
 *          4.每个web项目对应的是一个ServletContext
 *      用法:
 *         获取ServletContext对象;
 *         //1.
 *         ServletContext context = this.getServletContext();
 *         //2.
 *         ServletContext context2 = this.getServletConfig().getServletContext();
 *         //3.
 *         ServletContext context3 = request.getSession().getServletContext();
 *
 *         向ServletContext 中设置属性值:
 *         context.setAttribute(key,value);
 *         获取属性值:
 *         context.getAttribute(String key);
 *
 *         其他用途:
 *         1.获取web.xml配置的公共属性;
 *         在web.xml添加公共属性
 *         <context-param>
 *               <param-name>moyudan</param-name>
 *               <param-value>lovely</param-value>
 *         </context-param>
 *
 *         context.getInitParameter(String key)
 *         //如果有多个公共属性,使用多个context-param标签
 *         2.获取路径:
 *         context.getRealPath(String filename)获取某个文件的绝对路径
 *         context.getContextPath();获取某个项目的虚拟路径;
 *
 *
 *
 *
 *
 *
 *
 */

public class ServletContextServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取ServletContext对象
        //1.
        ServletContext context = this.getServletContext();
        //2.
        ServletContext context2 = this.getServletConfig().getServletContext();
        //3.
        ServletContext context3 = request.getSession().getServletContext();

        System.out.println(context==context2);
        System.out.println(context==context3);
        System.out.println(context3==context2);

        //设置属性值:
        context.setAttribute("111","sunzhen");
        //从web.xml获取参数值:
        String value = context.getInitParameter("moyudan");
        System.out.println(value);
        String value1 = context.getInitParameter("China");
        System.out.println(value1);
        //获取某个文件的绝对路径:
        String contextPath = context.getRealPath("web.xml");
        System.out.println(contextPath);

        //返回web的上下文路径:
        String path2 = context.getContextPath();
        System.out.println(path2);

    }
}
