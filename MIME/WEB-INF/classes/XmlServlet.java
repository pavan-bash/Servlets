import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class XmlServlet extends HttpServlet{
	public void service(HttpServletRequest request,
HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		   response.setContentType("text/xml");
out.print("<table>");
out.print("<tr><th>Sno</th><th>sname</th></tr>");
out.print("<tr><th>111</th><th>Sai</th></tr>");
out.print("<tr><th>222</th><th>Sudha</th></tr>");
out.print("</table>");
		out.close();
	}
}