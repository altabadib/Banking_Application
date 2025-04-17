package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Customer.CustomerBean;

public class EditDAO {
   CustomerBean bean=null;
   Connection con = DBMSConnection.getConnection();
    public int getEdit(long accno, double balance) {
        int k = 0;
        System.out.println(accno);
        System.out.println(balance);
        try {
        	PreparedStatement ps = con.prepareStatement("UPDATE Bank72 SET balance = ? WHERE accno = ?");
        	ps.setDouble(1, balance);
        	ps.setLong(2, accno);
        	k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        return k;
    }

	public CustomerBean getDetails(long accno) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from Bank72 Where accno=?");
			ps.setLong(1, accno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean = new CustomerBean();
				bean.setAccno(rs.getLong(1));
				bean.setBalance(rs.getDouble(2));
				bean.setName(rs.getString(3));
				bean.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return bean;
	}
}
