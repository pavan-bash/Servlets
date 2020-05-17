
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class LoginServlet extends HttpServlet{
	public void service(ServletRequest request,
		ServletResponse response) throws ServletException,IOException{

PrintWriter out = response.getWriter();
String username=request.getParameter("UN");
String password=request.getParameter("PW");

if(username.equalsIgnoreCase("sssit") &&
	password.equals("kphb"))
		{ out.print("Login is Success..."); }
else
		{ out.print("Login is Fail....."); }    

out.close();
	}
}