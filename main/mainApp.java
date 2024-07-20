package main;

import java.sql.*;

import main.src.*;
import main.utilities.*;


public class mainApp {

    public static void main(String[] args) {
        try {
            Connection conn = connectDB.createConnection();
            if(conn == null) return;
            Home home = new Home();
            home.createUI(conn);
            System.out.println("connection successfully established");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM directory;");
            printResultSet.printObject(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}