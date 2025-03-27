package BankApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBMSConnection {

	private static Connection con;
	static
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Batch40");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return con;
	}
	
	
}
