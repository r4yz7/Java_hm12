<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mmish
  Date: 25.10.2023
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All countries</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Countries</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Country name</th>
                <th>Count people</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var = "country" items="${countries}">
                    <tr>
                        <td>${country.id}</td>
                        <td>${country.countryName}</td>
                        <td>${country.countPeople}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-outline-secondary" >BACK</a>
    </div>
</body>
</html>
