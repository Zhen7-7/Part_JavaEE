<%--
  Created by IntelliJ IDEA.
  User: Sunzhen
  Date: 2021/1/14
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%--
    html注释
        也会转译成java文件 也会发送给浏览器 但浏览器不会执行
    java注释
        也会被转译,但是不会发给浏览器
    jsp注释
        不会被转译
--%>
<%--
    page:
            用来设置转译成servlet文件时的参数
        contentType:表示浏览器解析响信息的时候使用的解析编码和解析格式
        language:表示jsp要转译成的文件类型--目前只支持java
        import 导入需要的jar包 多个包需要用,隔开
        pageEncoding:设置页面的编码格式,这里设置 charset可以不设,一旦都设置了需要保持一致
        session:用来控制servlet中是否有session对象
        errorPage:当页面发生逻辑错误跳转的页面
        extends:选择要转译的sevlet类要继承的父类(包名+类名)


    局部代码块:
        可以将java代码跟页面展示的标签写到一个jsp页面中,java代码转译成的servlet文件中,java代码和输出是保存在service方法中
        缺点:(一般不使用)
            代码可读性比较差
            开发比较麻烦
    全局代码块:
        定义公共的方法有时候需要使用全局代码块<%!%> 生成的代码在Servlet类中
        调用的时候需要使用全局代码块
    脚本调用方法:
        使用<%= 世界调用变量和方法(必须有返回值)%>
        注意:不能在变量或方法后添加
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" pageEncoding="CESU-8" %>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    String str = "莫玉丹是猪猪";
    public void test(){
        System.out.println("我是全局代码块");
    }
%>
<%!
    String test2(){
        String str1="这是test2的返回结果";
        return str1;
    }
%>
<%
    int a = (int)((Math.random())*10);
    if(a>5){
%>
<!-- 这是 html注释 -->
<b>今天天气不错</b>
<%}else{%>
<b>今天天气真差</b>
<%test();}%>

<!-- 脚本调用方法-->
<%=str%>
<%=test2()%>

page jsp
</body>
</html>
