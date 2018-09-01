/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;
import java.sql.*;
import java.util.*;
/**
 *
 * @author SouvikPRAT
 */
public class ModelTestService2 {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    String sql="SELECT branches.ifsc,branches.bank_id,branches.branch,branches.address,branches.city,branches.district,branches.state,banks.name"+
    "FROM (branches JOIN banks ON ((branches.bank_id = banks.id))";
    String ifsc,branch,address,city,district,state,name;
    Integer id;
    public void getDetails()
    {
        try
        {
            ArrayList<String> ifscA=new ArrayList<String>();
            ArrayList<Integer> bankidA=new ArrayList<Integer>();
            ArrayList<String> branchA=new ArrayList<String>();
            ArrayList<String> addressA=new ArrayList<String>();
            ArrayList<String> cityA=new ArrayList<String>();
            ArrayList<String> districtA=new ArrayList<String>();
            ArrayList<String> stateA=new ArrayList<String>();
            ArrayList<String> banknameA=new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                 ifsc=rs.getString("ifsc");
                 ifscA.add(ifsc);
                 id=rs.getInt("bank_id");
                 bankidA.add(id);
                  branch=rs.getString("branch");
                 branchA.add(branch);
                  address=rs.getString("address");
                 addressA.add(address);
                  city=rs.getString("city");
                 cityA.add(city);
                  district=rs.getString("district");
                 districtA.add(district);
                  state=rs.getString("state");
                 stateA.add(state);
                  name=rs.getString("name");
                 banknameA.add(name);
            }
            for (int i = 0; i < ifscA.size(); i++) {
            System.out.println(ifscA.get(i)+" "+bankidA.get(i)+" "+
                    banknameA.get(i)+" "+branchA.get(i)+" "+
                    addressA.get(i)+" "+cityA.get(i)+" "+
                    districtA.get(i)+" "+stateA.get(i));
		}
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
