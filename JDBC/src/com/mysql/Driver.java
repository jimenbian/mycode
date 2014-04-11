package com.mysql;

import java.sql.*;

import com.mysql.jdbc.Statement;


public class Driver {
	public static void main(String[] args){ 
	  try {
		   
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("≤‚ ‘Õ®π˝");
		    java.sql.Connection conn;
		    conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","tiancailibo");
		    System.out.println("conn-------------"+conn);
		    Statement stmt=(Statement) conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from mytable");
		    while(rs.next()){                          
		    String name=rs.getString("name");
		     String sex=rs.getString("sex");
		     System.out.println("name------"+name+"--------sex-"+sex);
		    }
		   } catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   } catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
}
	}
