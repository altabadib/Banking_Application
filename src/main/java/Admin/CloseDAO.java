package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Customer.DBMSConnection;

public class CloseDAO {

	public static String msg;
	Connection con = DBMSConnection.getConnection();

	public String closeAccount(long accno) {
		try {
			PreparedStatement ps = con.prepareStatement("Select * from Bank72 where accno=?");
			ps.setLong(1, accno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps1 = con.prepareStatement("Delete from Bank72 where accno=?");
				ps1.setLong(1, accno);
				int k = ps1.executeUpdate();
				if (k > 0) {
					con.commit();
					msg = "Account Deleted Succesfully.";
				} else {
					msg = "Account Not Deleted Succesfully";
				}
			} else {
				msg = "Account DoesNot Exist";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

}
