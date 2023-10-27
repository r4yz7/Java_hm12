package com.example.java_lr12;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.plaf.nimbus.State;

@WebServlet(name = "capitalServlet", value = "/capitalServlet")
public class CapitalServlet extends HttpServlet {
    Connection conn;
    Statement statement;
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/countryDb","root","");
            statement = conn.createStatement();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            String query = "SELECT * FROM Country Co JOIN City Ci ON Ci.countryId = Co.Id WHERE Ci.isCapital = 1";
            ResultSet res = statement.executeQuery(query);
            List<City> cities = new ArrayList<>();
            while (res.next()){
                int id = res.getInt("id");
                String cityName = res.getString("cityName");
                String description = res.getString("description");
                boolean isCapital = res.getBoolean("isCapital");
                String countryName = res.getString("countryName");
                City city = new City(id,cityName,description,isCapital,countryName);
                cities.add(city);
            }
            request.setAttribute("cities",cities);
            request.getRequestDispatcher("/cities.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}