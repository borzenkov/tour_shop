<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">На главную</a>
<form method="post" action="login">
    <table>
        <tr>
            <td>Форма входа</td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>
                Пароль
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Отправить">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
