
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class LoginServlet extends HttpServlet{
	public void service(ServletRequest request,
		ServletResponse response) throws ServletException,IOException{

	 PrintWriter out=response.getWriter();
	 
	 //Req.g.p.logic
	 String username=
		 request.getParameter("USERNAME");
	 String password=
		 request.getParameter("PASSWORD");

	 //validate
	 if(username.equalsIgnoreCase("sssit") && password.equals("kphb"))
		{ out.print("Login Is Success...");}
	 else
		{ out.print("Login is Fail...."); }

	 out.close();
	}
}