package com.sunzhen.listen;

import org.omg.CORBA.Request;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class MyListen implements ServletRequestListener , ServletRequestAttributeListener , ServletContextListener ,ServletContextAttributeListener,HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request对象被销毁"+new Date());
//        servletRequestEvent......
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request对象被创建"+new Date());
    }

    @Override
    //增加属性配置
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request作用域添加数据");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override
    //删除
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request作用域删除数据");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override//替换
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request作用域属性替换");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Servletcontext创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Servletcontext销毁");

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletcontext作用域添加数据");
        System.out.println(servletContextAttributeEvent.getName());
        System.out.println(servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletcontext作用域移除数据");
        System.out.println(servletContextAttributeEvent.getName());
        System.out.println(servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletcontext作用域替换数据");
        System.out.println(servletContextAttributeEvent.getName());
        System.out.println(servletContextAttributeEvent.getValue());
    }
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session对象被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session对象被销毁");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session添加属性");
        System.out.println(httpSessionBindingEvent.getName());
        System.out.println(httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session删除属性");
        System.out.println(httpSessionBindingEvent.getName());
        System.out.println(httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session修改属性");
        System.out.println(httpSessionBindingEvent.getName());
        System.out.println(httpSessionBindingEvent.getValue());
    }

}
