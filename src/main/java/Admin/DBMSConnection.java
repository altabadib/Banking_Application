package Admin;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBMSConnection implements Closeable
{

	private static Connection con;
	static
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Batch40");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return con;
	}
	@Override
	public void close() throws IOException {
		
		
	}

	
}
