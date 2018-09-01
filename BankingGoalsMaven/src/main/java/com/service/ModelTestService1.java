/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;
import java.sql.*;

/**
 *
 * @author SouvikPRAT
 */
public class ModelTestService1 {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    String sql="Select address,city,district,state from branches where ifsc=?";
    String address,city,district,state;
    public void getDetails(String ifsc)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            ps=con.prepareStatement(sql);
            ps.setString(1,ifsc);
            rs=ps.executeQuery();
            while(rs.next())
            {
                 address=rs.getString("address");
                 city=rs.getString("city");
                 district=rs.getString("district");
                 state=rs.getString("state");
            }
            System.out.println("adress is "+address);
            System.out.println("city is "+city);
            System.out.println("district is "+district);
            System.out.println("state is "+state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
      try{
         if(ps!=null)
            con.close();
      }catch(SQLException se){}
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   
    }
}
