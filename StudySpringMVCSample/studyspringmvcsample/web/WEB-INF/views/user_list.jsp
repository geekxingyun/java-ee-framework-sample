<%@ page import="com.xingyun.model.TUserEntity" %>
<%@ page import="java.util.List" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<% out.print("<font color='red'>查询用户列表</font>"); %><br/><br/>
<%  for (TUserEntity e:(List<TUserEntity>)request.getAttribute("userList"))
{
%>
<li>
ID <% out.print(e.getId());%>
</li>
<li>
   用户名     <% out.print(e.getUsername());%>
</li>
<li>
  密码  <% out.print(e.getPassword());%>
</li>
<br/>
<%}%>


</body>
</html>