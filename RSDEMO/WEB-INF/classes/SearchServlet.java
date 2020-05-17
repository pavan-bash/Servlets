
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SearchServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		String keyword= request.getParameter("KEYWORD");

response.sendRedirect
("https://www.google.co.in/search?q="+keyword);

		out.close();
	}
}