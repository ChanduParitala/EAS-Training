package EAS.jsp.handson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Handson12")
public class Handson12 extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//using servlet to print hello world.
		System.out.println("Hello, World!");
		
		//write, http://localhost:8080/ServletHandson/Handson12?name=xxxxxxx, to pass parameter
		String name = request.getParameter("name");
		if (name!=null) {
			System.out.println("Welcome "+name);
		}
		
		PrintWriter pw = response.getWriter();
		pw.write("Hello, World!");
	}
}
