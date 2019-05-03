/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class SqlConn {

    Connection conn;
    Statement stmt;

    public SqlConn() throws ClassNotFoundException {

        try {
            System.out.println("COnnecy");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop-database", "root", "123456");
            System.out.println("john");
            stmt = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        new SqlConn();
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            System.out.println("Query: " + query);
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String query) {
       System.out.println("Query: " + query);
        try {
            return stmt.executeUpdate(query);
            
        }  

        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return -1;
    }

}
