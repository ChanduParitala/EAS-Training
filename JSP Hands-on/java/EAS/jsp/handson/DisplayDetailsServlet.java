package EAS.jsp.handson;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayDetailsServlet")
public class DisplayDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Stringid=request.getParameter("id");  
	    String name=request.getParameter("name");  
		String gender = request.getParameter("r");
		
		String sdob = request.getParameter("dob");
		LocalDate dob=null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		dob= LocalDate.parse(sdob, dtf);
		String fte = request.getParameter("fte");
		if(fte == null)
			fte="no";
		String department = request.getParameter("department");
		String sals = request.getParameter("sal");
	    int id = Integer.parseInt(Stringid);
	    int sal = Integer.parseInt(sals);
	   
		//populate the object.
		Employee e = new Employee(id, name,gender,dob,fte,department,sal);
		RequestDispatcher rd = request.getRequestDispatcher("display-details.jsp");
		rd.forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
