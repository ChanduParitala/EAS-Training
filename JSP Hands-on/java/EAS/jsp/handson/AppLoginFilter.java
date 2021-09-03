
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/Login1")
public class AppLoginFilter implements Filter {

	public void init(FilterConfig arg0) throws javax.servlet.ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, javax.servlet.ServletException {
		String str = "Filtering the inputs...";
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		PrintWriter pw = response.getWriter();
		pw.println("Filter Invoked..");
		
		if (name.equals("user")) {
			pw.write("User Invoked");
			chain.doFilter(request, response);
		}
		else{  
		    pw.print("username wrong!");  
		    RequestDispatcher rd=request.getRequestDispatcher("uFilter.jsp");  
		    rd.include(request, response);  
		    }  
	}

	@Override
	public void destroy() {
	}

}
