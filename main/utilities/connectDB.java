package main.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    private static String user = "postgres";
    private static String password = "noman";
    private static String connectionUrl = "jdbc:postgresql://localhost:5432/phdir";
    private static Connection conn = null;

    public static Connection createConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connectionUrl, user, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void closeConnection() throws SQLException {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
