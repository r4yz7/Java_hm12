<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Menu</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h1>Menu</h1>
  <br>
  <a class="btn btn-outline-info" href="countriesServlet">Show all countries</a>
  <br>
  <a class="btn btn-outline-info" href="citySearchServlet">Show cities by country</a>
  <br>
  <a class="btn btn-outline-info" href="capitalServlet">Show all capital</a>
  <br>
  <a class="btn btn-outline-info" href=capitalByCountryServlet>Show capital by countries</a>
  <br>
  <a class="btn btn-outline-info" href="topCountryServlet">Top 3 countries by number of cities</a>
  <br>
</div>
</body>
</html>