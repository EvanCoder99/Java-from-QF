<%@ page import="emp.entity.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 热心群众
  Date: 2023/9/15
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <table border="1" cellpadding="5">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>工资</th>
                <th>年龄</th>
                <th colspan="2">操作</th>
            </tr>
            <%
                List<Emp> emps = (List<Emp>) request.getAttribute("emps");
                for (Emp e : emps) {
            %>
            <tr>
                <td><%= e.getId()%></td>
                <td><%= e.getName()%></td>
                <td><%= e.getSalary()%></td>
                <td><%= e.getAge()%></td>
                <td><a href='<%=request.getContextPath()%>/manage/safe/delete?name=<%=e.getName()%>'>删除</a></td>
                <td><a href='<%=request.getContextPath()%>/manage/safe/showEmpController?id=<%=e.getId()%>'>修改</a></td>
            </tr>
            <% } %>
            <tr>
                <td colspan="6" align="center"><a href='<%=request.getContextPath()%>/add.html'>添加</a></td>
            </tr>

        </table>
    </body>
</html>
