/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.official.wears.site;

import static com.official.wears.site.DBConnector.db;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahendra
 */
public class LoginServelet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection dbConnection = DBConnector.getDbCon().conn;
            Statement statement = dbConnection.createStatement();

            String un = request.getParameter("username");
            String pw = request.getParameter("password");
            String dbPassWord = null;
            ResultSet res = statement.executeQuery("select password from customerlogininfo where username = '"+un+"'");
             while (res.next()) {
                 dbPassWord = res.getString(1);
                System.out.println(dbPassWord);
            }
            if (pw.trim().equals(dbPassWord)) {
                response.sendRedirect("cart.html");
                return;
            } else {
                response.sendRedirect("login.html");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServelet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
