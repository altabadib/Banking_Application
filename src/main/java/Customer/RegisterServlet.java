package Customer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		CustomerBean c = new CustomerBean();
		String pwd = req.getParameter("password");
		String confirmpwd=req.getParameter("confirmPassword");
		System.out.println(pwd);
		System.out.println(confirmpwd);
		if(pwd.equals(confirmpwd)) {
		c.setName(req.getParameter("name"));
		c.setAccno(Long.parseLong(req.getParameter("accountNumber")));
		c.setBalance(Double.parseDouble(req.getParameter("balance")));
		c.setPassword(req.getParameter("confirmPassword"));
		
		int k = new RegisterDAO().customerRegister(c);
		if(k>0)
		{
			req.setAttribute("msg", "Register Succesfully.");
			req.getRequestDispatcher("register.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Register Not Done Succesfully.");
			req.getRequestDispatcher("register.jsp").forward(req, res);
		}
		
		}
		else {
			PrintWriter pw = res.getWriter();
			pw.println("Password Must Be same.");
			req.getRequestDispatcher("register.html").include(req, res);
		}
		
	}

}
