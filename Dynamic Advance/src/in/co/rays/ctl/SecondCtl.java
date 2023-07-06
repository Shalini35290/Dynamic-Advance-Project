package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SecondCtl")
public class SecondCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in second ctl doGet");
		String fname = req.getParameter("FirstName");
		String lname = req.getParameter("LastName");
		System.out.println(fname);
		System.out.println(lname);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in second ctl doPost");
		String fname = req.getParameter("FirstName");
		String lname = req.getParameter("LastName");
		System.out.println(fname);
		System.out.println(lname);
	}

}
