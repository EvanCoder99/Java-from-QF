<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: 热心群众
  Date: 2023/9/4
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, String> map = new HashMap<>();
    map.put("江西省","宜春南昌九江");

    map.put("广东省","广州深圳佛山");


    System.out.println(map.get("江西省"));
    String s = request.getParameter("s");
    String city = null;
    if (s.equals("江西省")){

            response.getWriter().write(map.get(s));

    }else if (s.equals("广东省")){

        response.getWriter().write(map.get(s));

    }
%>