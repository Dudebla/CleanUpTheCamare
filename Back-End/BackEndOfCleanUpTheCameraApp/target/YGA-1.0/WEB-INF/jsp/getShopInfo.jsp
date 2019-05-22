<%--
  Created by IntelliJ IDEA.
  User: elite
  Date: 19-5-21
  Time: 下午11:18
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
    ID:
    <input type="text" name="id">
    <br>
    <button onclick="getShopInfo()"/>获取信息</button>
</form>
</body>
</html>


<script>
    function getShopInfo(){
        document.info.action="getShopInfo";
        document.info.submit();
    }
</script>
