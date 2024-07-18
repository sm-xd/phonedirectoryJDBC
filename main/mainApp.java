package main;

import java.sql.*;

import main.utilities.*;


public class mainApp {

    public static void main(String[] args) {
        try {
            Connection conn = connectDB.createConnection();
            System.out.println("connection successfully established");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM directory;");
            printResultSet.printObject(rs);
            if(conn == null) return;
            connectDB.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}