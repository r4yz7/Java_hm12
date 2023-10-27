package com.example.java_lr12;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.plaf.nimbus.State;

@WebServlet(name = "citySearchServlet", value = "/citySearchServlet")
public class CitySearchServlet extends HttpServlet {
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
       getServletContext().getRequestDispatcher("/countryForm.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            String queryCountry = "SELECT Co.Id, Co.countryName FROM Country Co WHERE Co.countryName = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(queryCountry);
            String country =request.getParameter("country");
            preparedStatement.setString(1,country);
            ResultSet res =preparedStatement.executeQuery();
            int countryId=0;
            String countryName="";
            while (res.next()){
                 countryId = res.getInt("id");
                 countryName = res.getString("countryName");
            }
            String sql = "SELECT * FROM City WHERE City.countryId = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(countryId));
            res = preparedStatement.executeQuery();
            List<City>cities = new ArrayList<>();
            while (res.next()){
                int id = res.getInt("id");
                String cityName = res.getString("cityName");
                String description = res.getString("description");
                boolean isCapital = res.getBoolean("isCapital");
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