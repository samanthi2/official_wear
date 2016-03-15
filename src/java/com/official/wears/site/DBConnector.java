/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.official.wears.site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahendra
 */
public class DBConnector {

    public Connection conn;
    private Statement statement;
    public static DBConnector db;

    public static void main(String[] args) {
        try {
            DBConnector dbConnection = new DBConnector();
         getDbCon();
         
         
            ResultSet rs = dbConnection.query("select password from customerlogininfo where username = 'dave123'");
           
            
            while (rs.next()) {
                String password = rs.getString(1);
                System.out.println(password);
            
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex);
             
             
        }

    }

    private DBConnector() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "officialWears";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "lakshi";
        try {
            
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
                      
            
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized DBConnector getDbCon() throws SQLException {
        if (db == null) {
            db = new DBConnector();
        }
        return db;

    }

    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not
     * available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException {
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;

    }

}
