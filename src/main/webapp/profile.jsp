<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">На главную</a><br>
<%
    Object emailAttribute = request.getSession().getAttribute("email");
    if (emailAttribute != null) {
%>
<a href="/editProfile.jsp">Редактировать профиль</a><br>
Ваш email: <%=emailAttribute%>
<%
    } else {
%>
Залогинься
<%
    }
%>
</body>
</html>
