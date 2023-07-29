package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.User;

@WebServlet("/addtask")
public class Addtask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String TaskName=req.getParameter("name");
		String Taskdescription=req.getParameter("description");
		int days=Integer.parseInt(req.getParameter("days"));
		
		Task task=new Task();
		task.setTaskName(TaskName);
		task.setTaskDescription(Taskdescription);
		task.setTaskdate(LocalDate.now());
		task.setCompleteionDate(LocalDate.now().plusDays(days));
		
		UserDao dao=new UserDao();
		dao.save(task);
		
		resp.getWriter().print("<h1 style='color:green'>Task Added Scusses</h1>");
		req.setAttribute("list", dao.fetchAllTasks());
		req.getRequestDispatcher("home.html").include(req, resp);
	}

}
