package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerTransferAmountDAO {

	public  String tranfer(long fromAccount, long toAccount, double amnt) {
		String msg = null;
		try {
			Connection con = DBMSConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select balance from bank72 where accno=?");
			ps.setLong(1, fromAccount);
			ResultSet rs = ps.executeQuery();
			//System.out.println(rs);
			if (rs.next()) {
				double balance = rs.getDouble(1);
				//System.out.println(balance);
				if (balance > 0 && amnt < balance) {
				//	System.out.println("Inside if");
					PreparedStatement ps1 = con.prepareStatement("select balance from bank72 where accno=?");
					ps1.setLong(1, toAccount);
					ResultSet rs1 = ps.executeQuery();
				//	System.out.println(rs1);
					if (rs1.next()) {
						double beneficaryBal = rs1.getDouble(1);
						PreparedStatement ps2 = con.prepareStatement("update Bank72 set balance=balance+? where accno=?");
						ps2.setDouble(1, amnt);
						ps2.setLong(2, toAccount);
						int k = ps2.executeUpdate();
					//	System.out.println(k);
						if (k > 0) {
							msg = "Amount Transfer Succesfully";
							PreparedStatement ps3 = con.prepareStatement("update Bank72 set balance=balance+? where accno=?");
							ps3.setDouble(1, -amnt);
							ps3.setLong(2, fromAccount);
							int executeUpdate = ps3.executeUpdate();
						//	System.out.println(executeUpdate);

							return msg;
						} else {
							msg = "Amount Not tansfer Succesfully...";
							return msg;
						}
					} else {
						msg = "Beneficary Account DoesNot Exist...";
						return msg;
					}

				} else {
					msg = "Insuffiecient Balance...";
					return msg;
				}
			} else {
				msg = "Account DoesNot Exist...";
				return msg;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
}
