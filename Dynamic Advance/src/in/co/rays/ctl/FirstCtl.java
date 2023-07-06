package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstCtl")
public class FirstCtl extends HttpServlet {

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("in FirstCtl doGet");
	String fname = req.getParameter("FirstName");
	String lname = req.getParameter("LastName");
	System.out.println(fname);
	System.out.println(lname);
		resp.sendRedirect("SecondCtl");
	
}
@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("in FirstCtl doPost");
	String fname = req.getParameter("FirstName");
	String lname = req.getParameter("LastName");
	System.out.println(fname);
	System.out.println(lname);
		
RequestDispatcher rd = req.getRequestDispatcher("SecondCtl");
rd.forward(req, resp);
	}
	

}
