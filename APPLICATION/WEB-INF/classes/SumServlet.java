import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SumServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		PrintWriter out=response.getWriter();
        response.setContentType("text/html");

		ServletContext context=getServletContext();
		int v1=Integer.parseInt(
			context.getInitParameter("V1"));
		int v2=Integer.parseInt(
			context.getInitParameter("V2"));
		int s=v1+v2;
		out.print("<h2 align=center> Sum is : "+s+"</h2>");
		out.close();
	}
}