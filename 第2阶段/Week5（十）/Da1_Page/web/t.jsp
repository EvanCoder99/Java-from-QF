<%@ page import="emp.entity.Emp" %><%--
  Created by IntelliJ IDEA.
  User: 热心群众
  Date: 2023/9/18
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%
            Emp e = new Emp(1,"zs",30000,25);
            request.setAttribute("q",e);
        %>
        ${q.age}

    </body>
</html>
