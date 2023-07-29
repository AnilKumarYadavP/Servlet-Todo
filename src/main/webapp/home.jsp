<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<form action="">
<table border="1px" >

<tr>
<th colspan="9">WELCOME TO TODO HOMEPAGES</th>
</tr>
<tr>
<td>Id</td>
<td>TaskName</td>
<td>Task description</td>
<td>Task Date</td>
<td>CompleteionDate</td>
<td>Status</td>
<td>Change</td>
<td>Delete</td>
<td>Update</td>
</tr>
<%
 
List<Task> list=(List<Task>) request.getAttribute("list");
for(Task task:list){
	%>
<tr>
<td><%=task.getId() %></td>
<td><%=task.getTaskName() %></td>
<td><%=task.getTaskDescription() %></td>
<td><%=task.getTaskdate() %></td>
<td><%=task.getCompleteionDate() %></td>
<td><%if(task.isStatus()) %>Completed<%else %>NotCompletd</td>
<td><button >Change</button></td>
<td><button >Update</button></td>
<td><button>Delete</button></td>
</tr>
<%
}
%>

</table>
<br>
<br>
<button style="margin-left:20px"><a href="task.html">Add task</a></button>
<button style="margin-left:500px"><a href="login.html">Logout</a></button>
<br>
</form>

</body>
</html>