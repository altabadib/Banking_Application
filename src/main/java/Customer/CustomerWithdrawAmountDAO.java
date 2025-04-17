package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerWithdrawAmountDAO {
	public static String res;
	public  String withdraw(long accno, double amnt) {
		
		Connection con = DBMSConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select balance from Bank72 where accno=?");
			ps.setLong(1, accno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				double balance=rs.getDouble(1);
				System.out.println(balance);
				if(balance>=amnt) {
					PreparedStatement ps1 = con.prepareStatement("UPDATE Bank72 SET balance = balance - ? WHERE accno = ?");
					ps1.setDouble(1, amnt);
					ps1.setLong(2, accno);
					int k = ps1.executeUpdate();
					System.out.println(k);
					if(k>0) {
						con.commit();
						res="Withdraw Succesfully";
					}
					else {
						res="Withdraw UnSuccesfull";
					}
				}
				else {
					res="Insufficient Balance";
				}
			}
			else {
				res="Account is Not Avalaiable";
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
