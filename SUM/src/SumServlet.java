
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SumServlet extends HttpServlet
{  public void service(ServletRequest request,
ServletResponse response) throws ServletException,
IOException{

	PrintWriter out=response.getWriter();
	      int a=10,b=20,s;
		  s=a+b;
		  out.print("Sum is : "+s);
	out.close();
	}
}