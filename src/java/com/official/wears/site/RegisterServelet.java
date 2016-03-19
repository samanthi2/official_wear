/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.official.wears.site;

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

public class RegisterServelet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection dbConnection = DBConnector.getDbCon().conn;
            Statement statement = dbConnection.createStatement();

            String userName = request.getParameter("username");
            String password = request.getParameter("pwd");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String email = request.getParameter("email");
            String gender = request.getParameter("singleSelect");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String nextCustomerId = this.getNextCustomerId(statement);
            
           
            
            statement.executeUpdate("Insert into customerinfo values "
                    + "('" + nextCustomerId
                    + "', '" + userName + "', '" + firstName + "', '" + lastName + "', "
                    + "'" + email + "', '" + gender + "', '" + dateOfBirth + "');");
            statement.executeUpdate("Insert into customerlogininfo values "
                    + "('" + nextCustomerId
                    + "','" + userName + "','" + password + "');");
            response.sendRedirect("cart.html");
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
return;
        } catch (SQLException ex) {
            Logger.getLogger(LoginServelet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Derives next available customer Id
     *
     * @param statement
     * @return
     * @throws SQLException
     */
    private String getNextCustomerId(Statement statement) throws SQLException {
        String lastCustId = null;
        ResultSet custIdResultSet = statement.executeQuery("select cusId from customerinfo order by cusId ASC");

        while (custIdResultSet.next()) {
            if (custIdResultSet.last()) {
                lastCustId = custIdResultSet.getString(1);

            } else {
                continue;
            }
        }
        int currentCustValue = Integer.parseInt(lastCustId.split("CUST")[1]);
        currentCustValue =currentCustValue+1;
        return "CUST" + String.format("%04d", currentCustValue);
    }
}
