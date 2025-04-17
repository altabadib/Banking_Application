package Admin;

import java.io.IOException;
import java.util.ArrayList;

import Customer.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			req.setAttribute("msg","Admin Log Out.");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else 
		{
			ArrayList<CustomerBean> listOfCustomer=new viewallDAO().getView();
			req.setAttribute("listOfCustomer", listOfCustomer);
			req.getRequestDispatcher("viewall.jsp").forward(req, res);
		}
		
		
	}

}
