package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	Connection con = DBMSConnection.getConnection();
    int k=0;
	public int customerRegister(CustomerBean c) {
		
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into Bank72 values(?,?,?,?)");
			ps.setLong(1, c.getAccno());
			ps.setDouble(2, c.getBalance());
			ps.setString(3,c.getName());
			ps.setString(4, c.getPassword());
			k = ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return k;
	}
	
}
