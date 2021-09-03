
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames = {"/AdminServlet", "/UserServlet"})
@WebServlet("/ApplicationLogFilter")
public class ApplicationLogFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 1L;
       

	public void doGet(ServletRequest request, ServletResponse response)
			throws IOException, ServletException {
		String str = "Filtering the inputs...";
		String name= request.getParameter("name");
		String id = request.getParameter("id");
		PrintWriter pw = response.getWriter();
		pw.write("Filter Invoked..");
		
		if(name=="user")
		{
			pw.write("User Invoked");
			RequestDispatcher rd = request.getRequestDispatcher("User");
			rd.forward(request, response);
		}
		else if(name=="admin")
		{
			pw.write("Admin Invoked");
			RequestDispatcher rd = request.getRequestDispatcher("AdminServlet");
			rd.forward(request, response);
		}
		else
		{
			pw.write("Wrong Input!..");
			RequestDispatcher rd = request.getRequestDispatcher("filter.jsp");
			rd.include(request, response);
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
