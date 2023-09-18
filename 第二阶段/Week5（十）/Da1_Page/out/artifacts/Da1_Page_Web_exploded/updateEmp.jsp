<%@ page import="emp.entity.Emp" %><%--
  Created by IntelliJ IDEA.
  User: 热心群众
  Date: 2023/9/16
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
<%--
        <%
            Emp emp = (Emp) request.getAttribute("emp"); //获取后端UpdateShowController存储的值
        %>
        &lt;%&ndash;JSP提交到UpdateShowController&ndash;%&gt;
        <form action="<%=request.getContextPath()%>/manage/safe/update">
            &lt;%&ndash; 编号不可变更，要么设置为只读，要么隐藏该控件 &ndash;%&gt;
            编号:<input type="text" name="id" value="<%=emp.getId()%>" readonly><br>
            姓名:<input type="text" name="name" value="<%=emp.getName()%>"><br>
            工资:<input type="text" name="salary" value="<%=emp.getSalary()%>"><br>
            年龄:<input type="text" name="age" value="<%=emp.getAge()%>"><br>
            <input type="submit" value="修改">
        </form>
        --%>

    <%
        Emp emp = (Emp) request.getAttribute("emp"); //获取后端UpdateShowController存储的值
    %>
        <form action="<%=request.getContextPath()%>/manage/safe/update">
            <%-- 编号不可变更，要么设置为只读，要么隐藏该控件 --%>
            编号:<input type="text" name="id" value="${emp.id}" readonly><br>
            姓名:<input type="text" name="name" value="${emp.name}"><br>
            工资:<input type="text" name="salary" value="${emp.salary}"><br>
            年龄:<input type="text" name="age" value="${emp.age}"><br>
            <input type="submit" value="修改">
        </form>
    </body>
</html>
