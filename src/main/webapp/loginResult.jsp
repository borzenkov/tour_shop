<%--
  Created by IntelliJ IDEA.
  User: imac
  Date: 25.11.16
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getAttribute("message")%>
<br>
<a href="login.jsp">Назад</a>
<br>
<a href="index.jsp">На главную</a>
</body>
</html>
