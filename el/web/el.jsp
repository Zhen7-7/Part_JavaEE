<%--
  Created by IntelliJ IDEA.
  User: Sunzhen
  Date: 2021/1/15
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--使用传统方式获取作用域的值-->
name:<%=request.getParameter("name")%>
pwd:<%=request.getParameter("pwd")%>
aa:<%=request.getAttribute("aa")%>
</body>
</html>
