package in.co.rays.ctl.pract;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtlPract")
public class LoginCtlPract extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String loginId = req.getParameter("LoginId");
	String pass = req.getParameter("Password");
	
	UserModel model = new UserModel();
	try {
		UserBean bean = model.authenticate(loginId, pass);
		if(bean != null) {
			req.setAttribute("fname", bean.getFirstName());
			RequestDispatcher rd = req.getRequestDispatcher("WelComePract.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("msg", "Invalid loginId and Password");
			RequestDispatcher rd = req.getRequestDispatcher("LoginPract.jsp");
			rd.forward(req, resp);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
