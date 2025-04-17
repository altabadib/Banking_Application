package Customer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable
{

	private String name;
	private long accno;
	private double balance;
	private String Password;
	
	
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "CustomerBean [name=" + name + ", accno=" + accno + ", balance=" + balance + ", Password=" + Password
				+ "]";
	}
	
	
	
}
