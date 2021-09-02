package EAS.jsp.handson;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignUpFormHandlerServlet")
public class SignUpFormHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "";
		String emailAddress = "";
		boolean preference = false;

		request.setAttribute("name", name);
		User u1 = new User(name, emailAddress, preference);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("u1.name", u1.getName());
		session.setAttribute("u1.mail", u1.getEmailAddress());
		session.setAttribute("u1.pref",u1.getPreference());
		
		RequestDispatcher rd = request.getRequestDispatcher("PersonalInformation.jsp");
		rd.forward(request, response);

	}

}
