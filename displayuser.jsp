<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Data</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">Registered Users</h1>
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${users}">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value[1]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div style="text-align: center;">
        <a href="register.jsp">Register New User</a>
    </div>
</body>
</html>
