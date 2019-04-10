<%--
  Created by IntelliJ IDEA.
  User: elite
  Date: 19-4-10
  Time: 下午8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="www.baidu.com" method="post">
        username:
        <input type="text" name="username">
        <br>
        password:
        <input type="text" name="password">
        <br>
        <input type="submit" value="login">
    </form>
</body>
</html>
