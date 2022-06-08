<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
List<Lunch> list=(List<Lunch>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/lunchapp/Create">新規追加</a>
<%if(list !=null && list.size()>0){ %>
<table border="1">
<tr><th>id</th><th>name</th><th>menu</th><th></th></tr>
<%for(Lunch lunch:list){ %>
<tr>
<td><%=lunch.getId() %></td>
<td><%=lunch.getName() %></td>
<td><%=lunch.getMenu() %></td>
<td>
<a href="/lunchapp/Update?id=<%=lunch.getId() %>">更新</a>
<a href="/lunchapp/Delete?id=<%=lunch.getId() %>" onclick="return confirm('id=<%=lunch.getId()%>を削除してよろしいですか？');">削除</a>
</td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>