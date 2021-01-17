package com.sunzhen.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 *  实现自定义过滤器:
 *      完成请求的拦截以及资源统一管理功能
 *      使用方法:
 *          定义普通java类,实现Filter接口
 *              init:完成初始化             tomcat启动的时候执行一次
 *              doFilter:进行处理           每次发送请求都会执行
 *              destroy:销毁                tomcat关闭的时候
 *      生命周期:
 *          从tomcat启动到tomcat关闭
 *
 *
 *
 * */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是filter逻辑处理");
        //添加此语句之后才能调用到对应的servlet
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter逻辑处理完成");
    }

    @Override
    public void destroy() {
        System.out.println("我是filter销毁功能");
    }
}
