package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Customer.CustomerBean;

public class viewallDAO {
	
	Connection con = DBMSConnection.getConnection();
	ArrayList<CustomerBean> listofcust=new ArrayList<CustomerBean>();
	
	public ArrayList<CustomerBean> getView() {
		try {
		PreparedStatement	ps = con.prepareStatement("select * from Bank72");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CustomerBean bean= new CustomerBean();
				bean.setAccno(rs.getLong(1));
				bean.setBalance(rs.getDouble(2));
				bean.setName(rs.getString(3));
				bean.setPassword(rs.getString(4));
				listofcust.add(bean);
			}
		} 
		catch (Exception e) 
		 {
			e.printStackTrace();
		}
		
		
		
		return listofcust;
	}

}
