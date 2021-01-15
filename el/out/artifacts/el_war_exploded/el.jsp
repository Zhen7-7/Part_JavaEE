<%@ page import="com.sunzhen.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
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
town:<%=((User)request.getAttribute("user")).getAddress().getTown()%>
香坊区:<%=((User)((ArrayList)request.getAttribute("list")).get(1)).getAddress().getTown()%>
mapValue:<%=((HashMap)request.getAttribute("map")).get("Haerbin")%>
名字:<%=((User)((HashMap)request.getAttribute("map2")).get("a1")).getName()%>


<!--
    使用传统方式获取request对象中的值有以下缺点:
    1.必须导入包
    2.进行类型的强制转换;
    3.层次结构比较复杂

    解决:使用El表达式;
-->

<br>
<!--使用el表达式获取作用域的值-->
name:${param.name}
pwd:${param.pwd}
aa:${aa}
town:${user.address.town}
香坊区:${list[1].address.town}
mapValue:${map.Haerbin}
名字:${map.a1.name}


<!--使用el表达时获取对象的顺序-->
<%
    pageContext.setAttribute("key","Hello pageContext");
    request.setAttribute("key","Hello request");
    session.setAttribute("key","Hello session");
    application.setAttribute("key","Hello application");
%>
<br>
key:${key}<br>
pageContext:${pageScope.key}
request:${requestScope.key}
session:${sessionScope.key}
application:${applicationScope.key}

<!--使用el表达时进行算术运算-->
${1+1}<br>
${2-2}<br>
${2*2}<br>
${2/2}<br>
${1/0}<br>
${1>2}<br>
${1>2?"男":"女"}
${1+"2"}

</body>
</html>
