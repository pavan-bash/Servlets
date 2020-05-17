import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class BigServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		PrintWriter out=response.getWriter();
        response.setContentType("text/html");

		ServletContext context=getServletContext();
		int v1=Integer.parseInt(
			context.getInitParameter("V1"));

		ServletConfig config=getServletConfig();
		int special=
			Integer.parseInt
			(config.getInitParameter("SPECIAL"));

		if(v1>special){		
		out.print("<h2 align=center>Biggest is : "+v1+"</h2>");
		}
		else
		{
		out.print("<h2 align=center>Biggest is : "+special+"</h2>");
		}

		out.close();
	}
}