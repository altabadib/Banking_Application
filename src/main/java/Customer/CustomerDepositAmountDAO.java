package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDepositAmountDAO {
	
	Connection con = DBMSConnection.getConnection();
	public static String msg;

	public String depositAmount(long accno, double amnt) {

		try {
			// Correct SQL Query
			if (amnt > 0) {
				PreparedStatement stm = con.prepareStatement("Select * from Bank72 where accno=?");
				stm.setLong(1, accno);
				ResultSet r = stm.executeQuery();
				if (r.next()) {
					PreparedStatement ps = con
							.prepareStatement("UPDATE Bank72 SET balance = balance + ? WHERE accno = ?");
					ps.setDouble(1, amnt);
					ps.setLong(2, accno);
					int k = ps.executeUpdate();
					if (k > 0) {
						msg = "Amount Deposited Succesfully.";
					} else {
						msg = "Amount Not Deposited Succesfully.";
					}
				} else {
					msg = "Account DoesNot Exist.";
				}
			} else {
				msg = "Amount Should Be Greater than Zero.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg; // Return updated balance or -1 if update failed
	}

}
