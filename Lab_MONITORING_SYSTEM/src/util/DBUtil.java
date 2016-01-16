package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class DBUtil {
	public  static Connection getConnection()
	{
		
		
		Connection con=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.192.71:1521:javadb","HJA52ORAUSER5D","tcshyd");
			//connecting the database with the help of properties file jdbc.properties ...
			//although i should have used the xml file but its not working because of incorrect schema
			//after loading the driver we will generate the username and password in the DAO class
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	

}
