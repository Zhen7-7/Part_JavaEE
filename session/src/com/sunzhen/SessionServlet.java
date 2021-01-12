package com.sunzhen;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session
 * 作用:
 *      解决相同用户发送不同请求时的数据共享问题;
 * 特点:
 *      1.服务器端存储共享数据的技术;
 *      2.session需要依赖cookie
 *      3.每个用户对应1个session对象
 *      4.每个session对象默认时常30min
 *      5.每次关闭浏览器的时候重新请求都会开启一个新的session对象,因为JSESSIONID保存在浏览器的内存中,是临时cookie
 *      关闭之后自然消失
 *
 * 使用:
 *      HttpSession session=request.getSession();
 */
public class SessionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置相应格式:
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset:utf-8");


        System.out.println("接收到请求");
        //获取session对象:
        HttpSession session = request.getSession();
        //getid方法获得id
        String id = session.getId();
        System.out.println("id为:"+id);

        response.getWriter().write("学习session");


    }
}
