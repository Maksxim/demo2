<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<a href="/register/list">LIST</a>
<a href="/register/delete">DELETE</a>
<% String name = request.getParameter("name"); %>
<% String address = request.getParameter("address"); %>
<% String email = request.getParameter("email"); %>
<p>Welcome   <% out.println(name); %> User!!!! You have registered.</p>
<p>Address:  <% out.println(address); %></p>
<p>Email:  <% out.println(email); %></p>
</body>
</html>