<%@ page import="emp.entity.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 热心群众
  Date: 2023/9/15
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<%--
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
                <td><a href='<%=request.getContextPath()%>/manage/safe/showEmp?id=<%=e.getId()%>'>修改</a></td>
            </tr>
            <% } %>
--%>
            <%--获取 EmpShowController 设置的员工list集合--%>
           <%-- <c:forEach items="${emps}" var="e">--%>

            <%--获取 EmpShowController 设置的page实体--%>
            <c:forEach items="${p.list}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.name}</td>
                    <td>${e.salary}</td>
                    <td>${e.age}</td>
                    <td><a href='<%=request.getContextPath()%>/manage/safe/delete?name=${e.name}'>删除</a></td>
                    <td><a href='<%=request.getContextPath()%>/manage/safe/showEmp?id=${e.id}'>修改</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6" align="center"><a href='<%=request.getContextPath()%>/add.html'>添加</a></td>
            </tr>
        </table>
        <a href="<%=request.getContextPath()%>/manage/safe/show?currentPage=1">首页</a>
        <c:if test="${p.currentPage != 1}">
            <a href="<%=request.getContextPath()%>/manage/safe/show?currentPage=${p.currentPage-1}">上一页</a>
        </c:if>
        <c:if test="${p.currentPage != p.pageCount}">
            <a href="<%=request.getContextPath()%>/manage/safe/show?currentPage=${p.currentPage+1}">下一页</a>
        </c:if>
        <a href="<%=request.getContextPath()%>/manage/safe/show?currentPage=${p.pageCount}">尾页</a>
        共${p.currentPage}/${p.pageCount}
    </body>
</html>
