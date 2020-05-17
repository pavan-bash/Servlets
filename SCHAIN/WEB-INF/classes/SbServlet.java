
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SbServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    PrintWriter out=response.getWriter();
	response.setContentType("text/html");
		out.print("<body bgcolor=green text=white>");
		out.print("<h1 align=center>SB Servlet From SA Servlet</h1>");
		out.print("</body>");
	out.close();
	}
}