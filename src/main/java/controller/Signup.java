package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		
		UserDao dao=new UserDao();
		User user=dao.fectchByEmail(email);

		if(user==null) {
		 user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setDob(LocalDate.parse(dob));
		user.setAddress(address);
		user.setEmail(email);
		user.setGender(gender);
		user.setMobile(Long.parseLong(mobile));	
		
		
		dao.save(user);
		
		rep.getWriter().print("<html><body><h3  style='color:purple' ><i style='color:blue'>Account is Created</html></body></h3  >\");");
		req.getRequestDispatcher("login.html").include(req, rep);

	}
		else {
			rep.getWriter().print("<h1 style='color:red'>Email Already exits</h1>");
			req.getRequestDispatcher("signup.html").include(req, rep);
		}
	}
}
