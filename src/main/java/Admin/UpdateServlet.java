package Admin;

import java.io.IOException;

import Customer.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session==null) {
			req.setAttribute("msg", "Session Log Out.");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else {
			String amnt = req.getParameter("balance");
			double balance=Double.parseDouble(amnt);
			
			CustomerBean cb =(CustomerBean) session.getAttribute("customerBean");
			
			//String no = req.getParameter("accno");
			long accno=cb.getAccno();
		//	AdminBean ab =(AdminBean) session.getAttribute("adminBean");
			int k = new EditDAO().getEdit(accno, balance);
			if(k>0) {
				req.setAttribute("msg", "Updated Sucessfully.");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Not Updated Sucessfully.");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
			}
		}
		
	}
	
}
