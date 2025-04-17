package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInDAO {
	Connection con = DBMSConnection.getConnection();
	CustomerBean bean= null;
	public CustomerBean getLogIn(long accno,String password) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from Bank72 where accno=? AND password=?");
			ps.setLong(1, accno);
			ps.setString(2, password);
		     ResultSet rs = ps.executeQuery();
		     if(rs.next()) {
		    	bean = new CustomerBean();
		    	bean.setAccno(rs.getLong(1));
		    	bean.setBalance(rs.getDouble(2));
		    	bean.setName(rs.getString(3));
		    	bean.setPassword(rs.getString(4));
		     }
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return bean;
	}

}
