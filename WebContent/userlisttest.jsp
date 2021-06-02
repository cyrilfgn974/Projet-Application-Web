<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,entities.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des utilisateurs</title>
</head>
<body>

    <%
    Collection<User> users = new ArrayList<User>();

    for (User user: users) {%>
        <p><%= user.getUsername()%></p>
    <%
    }
%>

</body>
</html>