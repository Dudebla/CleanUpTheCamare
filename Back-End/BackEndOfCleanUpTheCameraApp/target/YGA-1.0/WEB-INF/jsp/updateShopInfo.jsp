<%--
  Created by IntelliJ IDEA.
  User: elite
  Date: 19-5-22
  Time: 下午3:01
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
<% request.setCharacterEncoding("UTF-8"); %>
<form action="" method="post" name="info" accept-charset="utf-8" onsubmit="document.charset='utf-8';">
    ID:
    <input type="text" name="id">
    <br>
    Name:
    <input type="text" name="name">
    <br>
    Address:
    <input type="text" name="address">
    <br>
    Introduction:
    <input type="text" name="intro">
    <br>
    Status:
    <input type="text" name="status">
    <br>
    Score:
    <input type="text" name="score">
    <br>
    <button onclick="updateShopInfo()"/>更新信息</button>
</form>
</body>
</html>


<script>
    function updateShopInfo(){
        document.info.action="updateShopInfo";
        document.info.submit();
    }
</script>
