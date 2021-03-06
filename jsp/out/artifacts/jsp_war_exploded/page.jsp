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
    页面导入的方式
        静态导入：
            <%@ include file="staticImport.jsp"%>  file中填写的是jsp文件的相对路径
            不会将静态导入的页面生成一个新的servlet文件，而是将两个文件合并，
            优点：运行效率高
            缺点：两个页面会耦合到一起，不利于维护，两个页面中不能存在相同名称的变量名
        动态导入：
            <jsp:include page="dynamicImport.jsp"></jsp:include>
            两个页面不会进行合并，分别生成自己的servlet文件，但是页面在最终展示的时候是合并到一起的
            优点：没有耦合，可以存在同名的变量
        请求转发:
            在jsp中也可以试下请求转发功能
            <jsp:forward page:"forward.jsp"></jsp:forward>  page填写的是jsp页面的相对路径;
            注意:在标签中间不可以添加任何字符,除了<jsp:param name:"" value="">
            在转发的页面如果先要获得属性值通过 request.getParameter(String key);

        九大对象：
                pageContext：表示页面的上下文的对象封存了其他的内置对象，封存了当前页面的运行信息
                            注意：每一个页面都有一个对应的pagecontext对象，
                            伴随着当前页面的结束而结束
                request：封装当前请求的数据，由tomcat创建，一次请求对应一个request对象
                session：用来封装同一个用户的不同请求的共享数据，一次会话对应一个session对象
                application：相当于ServletContext对象，一个web项目只有一个对象，存储着所有用户的共享数据，从服务器启动到服务器结束
                response：响应对象，用来响应请求数据，将处理结果返回给浏览器，可以进行重定向
                page:代表当前jsp对象，跟java中的this指针类似
                exception：异常对象，存储当前运行的异常信息，必须在page指令=中添加属性isErrorPage=true
                config:相当于Serlverconfig对象，用来获取web.xml中配置的数据，完成servlet的初始化操作
                out：响应对象，jsp内部使用，带有缓存区的响应对象，效率要高于repsonse
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

<%@ include file="staticImport.jsp"%>
<jsp:include page="dynamicImport.jsp"></jsp:include>

<%--<!-- 请求转发-->
<jsp:forward page="forward.jsp">
    <jsp:param name="beijing" value="busy"/>
    <jsp:param name="haerbin" value="cold"/>
</jsp:forward>--%>



<a href="a/a.jsp">aaa</a>
<a href="b/b.jsp">bbb</a>

page jsp
</body>
</html>
