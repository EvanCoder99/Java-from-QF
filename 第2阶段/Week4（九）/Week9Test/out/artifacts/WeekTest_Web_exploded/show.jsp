<%@ page import="java.util.List" %>
<%@ page import="leave.entity.LeaveInfo" %><%--
  Created by IntelliJ IDEA.
  User: 热心群众
  Date: 2023/9/16
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <script src="<%=request.getContextPath()%>/js/jquery-1.11.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">

        <div class="container">
            <div class="text-left">
                <input type="button" value="QA系统请假页面" class="btn btn-default btn-lg btn-block">
            </div>

            <br>
            <!-- table效果  table-striped；隔行换色  table-hover悬停 -->
            <table class="table table-striped table-hover table-bordered">
                <tr>
                    <th>编号</th>
                    <th>请假人</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>请加内容</th>
                    <th>审批人</th>
                    <th>审批状态</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <%
                        List<LeaveInfo> list = (List<LeaveInfo>) request.getAttribute("leaveInfo");//获取请假信息
                        for (LeaveInfo l : list) {
                    %>
                    <td><%=l.getId()%></td>
                    <td><%=l.getUser_id()%></td>
                    <td><%=l.getStarttime()%></td>
                    <td><%=l.getEndtime()%></td>
                    <td><%=l.getContent()%></td>
                    <td><%=l.getName()%></td>
                    <td><button class="bt"><%=l.getStatus()%></button></td>
                    <td><a href="<%=request.getContextPath()%>/leave/delete?id=<%=l.getId()%>">删除</a></td>
                </tr>
                <% } %>
                <td colspan="8" align="center"><a href="<%=request.getContextPath()%>/add.html">添加</a></td>
            </table>
        </div>

        <script>
            $(".bt").each(function () {
                if ($(this).text() == 0){   //未审批
                    $(this).text("未审批").addClass("btn btn-danger");
                }else if ($(this).text() == 1){
                    $(this).text("已审批").addClass("btn btn-success");
                }
            })
        </script>

    </body>
</html>
