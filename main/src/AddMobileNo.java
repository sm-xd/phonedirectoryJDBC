package main.src;

import java.sql.Connection;
import java.sql.PreparedStatement;

import main.utilities.*;

public class AddMobileNo {

    private String query = "INSERT INTO public.directory (fname, mname, lname, city,\"number\") VALUES (?, ?, ?, ?, ?)";
    private PreparedStatement pstmt = null;

    public boolean addData(MobileNo mobile, Connection conn){
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, mobile.getFname());
            pstmt.setString(2, mobile.getMname());
            pstmt.setString(3, mobile.getLname());
            pstmt.setString(4, mobile.getCity());
            pstmt.setString(5, mobile.getMobileNo());

            pstmt.executeUpdate();
            if(pstmt!=null){
                pstmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
