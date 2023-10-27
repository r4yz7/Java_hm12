package com.example.java_lr12;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.plaf.nimbus.State;

@WebServlet(name = "capitalByCountryServlet", value = "/capitalByCountryServlet")
public class CapitalByCountryServlet extends HttpServlet {
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
        getServletContext().getRequestDispatcher("/countryFormForCapital.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            String query = "SELECT * FROM Country Co JOIN City Ci on Ci.countryId = Co.id WHERE Co.countryName = ? and Ci.isCapital = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            String countryName = request.getParameter("country");
            preparedStatement.setString(1,countryName);
            ResultSet res = preparedStatement.executeQuery();
            City city = new City();
            while (res.next()){
                int id = res.getInt("id");
                String cityName = res.getString("cityName");
                boolean isCapital = res.getBoolean("isCapital");
                String descriptions = res.getString("description");
                city = new City(id,cityName,descriptions,isCapital,countryName);
            }
            request.setAttribute("city",city);
            request.getRequestDispatcher("/capital.jsp").forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}