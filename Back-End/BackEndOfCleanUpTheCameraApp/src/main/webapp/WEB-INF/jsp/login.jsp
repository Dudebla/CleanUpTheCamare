<%--
  Created by IntelliJ IDEA.
  User: elite
  Date: 19-4-10
  Time: 下午8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<form action="" method="post" name="info">
    username:
    <input type="text" name="username">
    <br>
    password:
    <input type="text" name="password">
    <br>
    <button onclick="login()"/>登录</button>
    <button onclick="signup()"/>注册</button>
</form>
</body>
</html>


<script>
    function login(){
        document.info.action="login";
        document.info.submit();
    }
    function signup() {
        document.info.action = "signUp";
        document.info.submit();
    }
</script>