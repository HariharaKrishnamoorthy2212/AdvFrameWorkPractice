package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleupdateJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver=new Driver();
		//Step 1: Register the driver
		DriverManager.registerDriver(driver);
		//step 2:Get Connection With DataBase
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root" ,"hari");
		//Step 3: 
		Statement sta=con.createStatement();
		
		String querry= "insert into table empinfo values('kalai','chenai',08);";
		int result= sta.executeUpdate(querry);
		if(result==1) {
			
			System.out.println("data aadded ");
			
		}
		con.close();
	}

}
