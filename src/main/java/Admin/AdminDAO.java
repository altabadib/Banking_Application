package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Customer.DBMSConnection;

public class AdminDAO {
	AdminBean bean=null;
	Connection con = DBMSConnection.getConnection();
	public int k = 0;

	public AdminBean getAdmin(String username, String password) {

		try {
			PreparedStatement ps = con.prepareStatement("select * from Admin72 where username=? And password=?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				bean= new AdminBean();
				bean.setUsername(rs.getString(1));
				bean.setPassword(rs.getString(2));		
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return bean;
	}

}
