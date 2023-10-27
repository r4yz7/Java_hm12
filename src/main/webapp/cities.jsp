<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmish
  Date: 25.10.2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Cities</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>city name</th>
                <th>Description</th>
                <th>Country</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var = "city" items="${cities}">
                    <tr>
                        <td>${city.id}</td>
                        <td>${city.cityName}</td>
                        <td>${city.description}</td>
                        <td>${city.country}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-outline-secondary" href="index.jsp">BACK</a>
    </div>
</body>
</html>
