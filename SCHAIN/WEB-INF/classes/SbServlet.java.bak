
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SaServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    PrintWriter out=response.getWriter();
	response.setContentType("text/html");
		out.print("<body bgcolor=green text=white>");
		out.print("<h1 align=center>SA Servlet</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("/sb.com");
		rd.include(request,response);
		out.print("</body>");
	out.close();
	}
}