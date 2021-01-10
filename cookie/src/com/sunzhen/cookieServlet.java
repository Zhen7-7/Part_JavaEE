package com.sunzhen;

import javax.servlet.http.Cookie;
import java.io.IOException;

/**
 *cookie:用来处理客户端发送不同请求的时候如何使用相同的参数信息;
 *cookie的使用
 *            Cookie cookie = new Cookie("00001", "beijing");
 *            response.addCookie(cookie);
 *            设置cookie的参数:
 *            cookie.setMaxAge(int seconds);
 *            cookie.setPath(String url)
 *            获取cookie对象:
 *            Cookie[] cookies =request.getCookies();
 *
 *特点:
 *      1.cookie是保存在浏览器的数据名称;
 *      2.cookie分类:临时cookie:默认存储在内存中 当浏览器关闭时cookie自动失效
 *                   持久化cookie:保存在浏览器的某个存储目录,当时间过期之后才失效
 *      3.每个cookie对象只能保存1个key-value数据;想要储存多个k-v数据就要创建多个对象
 *
 */

public class cookieServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");



        //创建cookie对象
        Cookie cookie = new Cookie("00001", "beijing");
        Cookie cookie1 = new Cookie("0002","shanghai");

        //给cookie对象添加时间有效期:   单位是s
        cookie.setMaxAge(3*24*3600);
        //给cookie设置固定路径值
        cookie1.setPath("/cookie/abc");
        //将cookie设置到response对象中
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.getWriter().write("莫玉丹是只笨猪");
    }
}
