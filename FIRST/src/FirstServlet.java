
//FirstServlet.java
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class FirstServlet extends HttpServlet
{
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{

		PrintWriter out=response.getWriter();
		out.print("Welcome to S E R V L E T ...!");
		out.close();
	}
}