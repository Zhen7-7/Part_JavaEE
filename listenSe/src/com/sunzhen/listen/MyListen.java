package com.sunzhen.listen;

import org.omg.CORBA.Request;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.Date;

public class MyListen implements ServletRequestListener , ServletRequestAttributeListener {
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
        System.out.println("向request作用域添加数据");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override
    //删除
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("向request作用域删除数据时");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());
    }

    @Override//替换
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request作用域属性替换");
        System.out.println(servletRequestAttributeEvent.getName());
        System.out.println(servletRequestAttributeEvent.getValue());

    }
}
