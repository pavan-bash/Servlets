import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class StudentServlet extends HttpServlet{
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		String fname=request.getParameter("FNAME");
		String lname=request.getParameter("LNAME");
		String age=request.getParameter("AGE");

		out.print("<h1> Fname : is "+fname);
		out.print("<h1> Lname is : "+lname);
		out.print("<h1> Age is : "+age+"</h1>");
		
		out.close();
	}

}