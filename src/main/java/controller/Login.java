package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
 
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao = new UserDao();
		User user = dao.fectchByEmail(email);

		if (user == null) {
			rep.getWriter().print("<h1 style='color:red'>Invalid Email </h1>");
			req.getRequestDispatcher("login.html").include(req, rep);
			req.getRequestDispatcher("home.html").include(req, rep);
		} else {
			if (user.getPassword().equals(password)) {
				rep.getWriter().print("<h1 style='color:red'>Login Successful </h1>");
				//fetch data from database
				//fetch data from database
				List<Task> list	=dao.fetchAllTasks();
					// set the data in request
				req.setAttribute("list", list);
					RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
					dispatcher.include(req, rep);
			} else {
				rep.getWriter().print("<h1 style='color:red'>Invalid Password </h1>");
				req.getRequestDispatcher("login.html").include(req, rep);
			}

		}

		
	}

}
