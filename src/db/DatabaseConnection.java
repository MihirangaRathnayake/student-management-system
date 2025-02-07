/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String username = "root";
    private static final String password = "";
    private static final String dataConn = "jdbc:mysql://localhost:3306/ead-cw"; 

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dataConn, username, password);
            return con;
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); 
            ex.printStackTrace(); 
            return null; 
        }
    }
}
