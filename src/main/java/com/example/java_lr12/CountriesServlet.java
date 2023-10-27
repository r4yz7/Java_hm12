package com.example.java_lr12;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.plaf.nimbus.State;

@WebServlet(name = "countriesServlet", value = "/countriesServlet")
public class CountriesServlet extends HttpServlet {
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String sql = "SELECT * FROM Country";
            ResultSet res =statement.executeQuery(sql);
            List<Country> countries = new ArrayList<>();
            while (res.next()){
                int id = res.getInt("id");
                String countryName = res.getString("countryName");
                int countPeople = res.getInt("countPeople");
                Country country = new Country(id,countryName,countPeople);
                countries.add(country);
            }
            request.setAttribute("countries",countries);
            request.getRequestDispatcher("/countries.jsp").forward(request,response);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}