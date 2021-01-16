<%--
  Created by IntelliJ IDEA.
  User: Sunzhen
  Date: 2021/1/16
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%--
    Jstl
    帮我们在jsp页面中添加复杂的逻辑判断,避免逻辑代码和页面标签混为一谈
    JSTL是EL的扩张,同时JSTL依赖于EL,为了方便地从作用域中取值;

    JSTL的导入:
        添加jstl.jar  standard.jar添加到WEB-INF下的lib目录
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    标签分类:
        #核心标签库:
        *格式化标签库
        _函数标签库
        _XML标签库
        _SQL标签库
    标签学习:
    <c:out value="嘿嘿"></c:out>  输出标签
        value:填写要输出的值
        default:默认值
    <c:set var="java" value="pageContext"></c:set>向作用域设置属性值
        var:表示参数的key
        value:表示参数的值
    注意:当只配置这两个属性的时候,默认是想pageContext作用域设置属性,可以通过参数来选择向哪个作用域设置
    <c:remove var="java"></c:remove>删除作用域的数据:
        var:表示参数的key
        scope:删除指定作用域的数据
        注意:如果没有指定scope属性,那么默认会把所有的作用域的参入全部删除
    <c:if test("${a>5})>        逻辑判断: if判断
        <h1>显示的内容<h1>
    </c:if>'
        test:填写逻辑判断表达时
        var:条件表达时的结果存储变量
        scope:结果变量存储的作用域


        //进行多重逻辑判断  类似于switch
        <c:set var="age" value="20"></c:set>
        <c:choose>
            <c:when test="${age<10}">
                <h1>小孩</h1>
            </c:when>
              <c:when test="${age<20}">
                <h1>青少年</h1>
            </c:when>
              <c:when test="${age<30}">
                <h1>青年</h1>
            </c:when>
              <c:when test="${age<40}">
                <h1>中年</h1>
            </c:when>
            <c:otherwise>
                <h3>i don't know</h3>
            </c:otherwise>



--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("str","happy");
    request.setAttribute("hello","world");
    request.setAttribute("java","1234");
%>
    <c:out value="吼吼" default="嘿嘿" ></c:out><br>
    <c:out value="${str}" default="嘎嘎"></c:out><br>
    <c:out value="${hello}"></c:out><br>


    <!-- 向作用域设置属性值 -->
    <c:set var="java" value="pageContext" scope="page"></c:set>
    <c:set var="java" value="request" scope="request"></c:set>
    <c:set var="java" value="session" scope="session"></c:set>
    <c:set var="java" value="application" scope="application"></c:set>

    <c:out value="${java}"></c:out><br>
    <c:out value="${pageScope.java}"></c:out><br>
    <c:out value="${requestScope.java}"></c:out><br>
    <c:out value="${sessionScope.java}"></c:out><br>
    <c:out value="${applicationScope.java}"></c:out><br>

<!--删除作用域的数据-->
    <c:remove var="java"></c:remove>
    <c:out value="${java}"></c:out><br>
    <c:out value="${pageScope.java}"></c:out><br>
    <c:out value="${requestScope.java}"></c:out><br>
    <c:out value="${sessionScope.java}"></c:out><br>
    <c:out value="${applicationScope.java}"></c:out><br>

<%
    int i=10;
    if(i>2){
%>
    jstl真好学
<%
    }

%>
<c:set var="a" value="6"></c:set>
<c:if test="${a>3}" var="flag" scope="request">
    <h1>jstl is esay </h1>
</c:if>

<c:set var="age" value="20"></c:set>
<c:choose>
    <c:when test="${age<10}">
        <h1>小孩</h1>
    </c:when>
      <c:when test="${age<20}">
        <h1>青少年</h1>
    </c:when>
      <c:when test="${age<30}">
        <h1>青年</h1>
    </c:when>
      <c:when test="${age<40}">
        <h1>中年</h1>
    </c:when>
    <c:otherwise>
        <h3>i don't know</h3>
    </c:otherwise>


</c:choose>
</body>
</html>
