package in.co.rays.ctl.pract;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.model.UserModel;

@WebServlet("/UserListCtlPract")
public class UserListCtlPract extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserModel model = new UserModel();
	try {
		List list = model.Search();
		req.setAttribute("List", list);
		RequestDispatcher rd = req.getRequestDispatcher("UserListViewPract.jsp");
		rd.forward(req, resp);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
