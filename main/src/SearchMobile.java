package main.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.utilities.MobileNo;

public class SearchMobile {
    private String query = "SELECT fname, mname, lname, city, \"number\" FROM public.directory WHERE \"number\" = ?";
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public MobileNo searchByMobileNo(Connection conn, String mobileNo){
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, mobileNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String fname = rs.getString("fname");
                String mname = rs.getString("mname");
                String lname = rs.getString("lname");
                String city = rs.getString("city");
                String number = rs.getString("number");

                return new MobileNo(fname, mname, lname, city, number);
            } else {
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
