package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Customer.DBMSConnection;

public class BalanceDAO {
	
	public double getBalance(long accno)
	{
		Connection con = DBMSConnection.getConnection();
		double balance=0;
		try {
			PreparedStatement ps= con.prepareStatement("select balance from Bank72 where accno=?");
			ps.setLong(1, accno);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			balance= rs.getLong(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}

}
