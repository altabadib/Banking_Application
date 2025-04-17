package Customer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginServlet")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long accno = Long.parseLong(req.getParameter("accountNumber"));
        String password = req.getParameter("password");
        CustomerBean bean = new LogInDAO().getLogIn(accno, password);
        System.out.println(bean);
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        if (bean!=null) {
            // ✅ Redirect to index.html with login success message
        		HttpSession session = req.getSession();
        		session.setAttribute("bean", bean);
            ((HttpServletResponse) res).sendRedirect("indexCustomer.jsp?login=success");
        		//req.getRequestDispatcher("indexCustomer.jsp").forward(req, res);
        } else {
            // Stay on the login page and show failure message
            pw.println("<script>alert('Customer Account is not available.');</script>");
            req.getRequestDispatcher("login.html").include(req, res);
        }
    }
}
