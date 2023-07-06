package in.co.rays.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	//set a cookie;
	String name = req.getParameter("cookieName");
	String value = req.getParameter("cookieValue");
	Cookie c = new Cookie(name,value);
	c.setMaxAge(20);
	resp.addCookie(c);
	
	
	
	}
	
	

}
