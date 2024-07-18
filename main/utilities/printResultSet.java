package main.utilities;

import java.sql.*;

public class printResultSet {
    public static void printObject(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        boolean hasRows = false;

        while (rs.next()) {
            if(!hasRows) {
                hasRows = printColumns(metaData, columnCount);
                System.out.println("\n");
            }
            for (int i = 0; i < columnCount; i++) {
                System.out.printf("%-20s",rs.getObject(i + 1));
            }
            System.out.println();
        }
        if (!hasRows) {
            System.out.println("No data available.");
        }
    }
    public static boolean printColumns(ResultSetMetaData metaData, int columnCount) throws SQLException{
        for (int i = 0; i < columnCount; i++) {
            System.out.printf("%-20s", metaData.getColumnName(i+1));
        }
        return true;
    }
}
