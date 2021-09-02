package EAS.jsp.handson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PreferenceHandlerServlet")
public class PreferenceHandlerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pref = request.getParameter("pref");
		
		boolean bpref;
		if(pref == null)
			bpref=false;
		else
			bpref=true;
		
		User u2 =new User();
		u2.setName(name);
		u2.setEmailAddress(mail);
		u2.setPreference(bpref);
		
		session.setAttribute("u1.name", u2.getName());
		session.setAttribute("u1.mail", u2.getEmailAddress());
		session.setAttribute("u1.pref", u2.getPreference());
		
		RequestDispatcher rd = request.getRequestDispatcher("Preference.jsp");
		rd.forward(request, response);
		
	}

}
