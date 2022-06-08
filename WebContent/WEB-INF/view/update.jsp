<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Lunch lunch = (Lunch)request.getAttribute("lunch");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/lunchapp/Update" method="post">
名前：<input type="text" name="name" value="<%=lunch.getName() %>"><br>
メニュー：<input type="text" name="menu" value="<%=lunch.getMenu() %>"><br>
<input type="hidden" name="id" value="<%=lunch.getId() %>">
<button type="submit">更新</button>
</form>
</body>
</html>