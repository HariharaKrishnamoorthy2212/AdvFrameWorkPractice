package practice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


import com.mysql.jdbc.Driver;

public class SampleExcuteQueryJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver=new Driver();
		//Step 1: Register the driver
		DriverManager.registerDriver(driver);
		//step 2:Get Connection With DataBase
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root" ,"hari");
		//Step 3: 
		Statement sta=con.createStatement();
		
		ResultSet result= sta.executeQuery("select * From empinfo");
		while (result.next()) {
			
			String value=result.getString(1);
			System.out.println(value);
		}
	
		con.close();
	}

}
