package com.sunzhen.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("这是第二个filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("这是第二个 filter 逻辑处理");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("这是第二个 filter 处理结束");
    }

    @Override
    public void destroy() {
        System.out.println("我是第二个 filter 销毁功能");
    }
}
