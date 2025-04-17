package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class AdminServlet extends HttpServlet

{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");

	    AdminBean ab = new AdminDAO().getAdmin(username, password);

	    if (ab == null) {
	        res.setContentType("text/html");
	        PrintWriter pw = res.getWriter();
	        pw.println("<script>alert('Admin Account is not available.'); window.location='adminLogin.html';</script>");
	    } else {
	        HttpSession session = req.getSession();
	        session.setAttribute("bean", ab);
	        // ✅ Redirect instead of forward to include URL parameter
	        res.sendRedirect("index.jsp?login=success");
	    }
	}
	
}