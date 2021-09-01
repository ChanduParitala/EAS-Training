package EAS.jsp.handson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Handson12")
public class Handson12 extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		//using servlet to print hello world.
		pw.write("Hello, World!<br>");

		
		pw.println("<HTML><HEAD><TITLE>Hello World!</TITLE>"+"</HEAD><BODY><form action=\"Welcome\">name: <input name=\"name\" type=\"text\" /><input type=\"submit\" value=\"submit\"/></form></BODY></HTML>");

		//write, http://localhost:8080/ServletHandson/Handson12?name=xxxxxxx, to pass parameter
		
	}
}
