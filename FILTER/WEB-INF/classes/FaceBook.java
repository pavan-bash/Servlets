ADV-JAVA [adv_630]
ServletFilter Application
==============================
register.html
==============================
<html>
  <body bgcolor=green text=white>
     <form action="student.com" method="post">
	 <h1 align=center> Register  Page </h1>
	 <hr><br><br>
	     <pre>
		    <h2>
			Enter Fname : <input type=text name=FNAME>
			Enter LName : <input type=text name=LNAME>
			<input type=submit value=register>
			</h2>
		 </pre>
	 </form>
  </body>
</html>
****************************************************
ValidateServlet.java
=======================================
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ValidateServlet implements Filter{
	public void init(FilterConfig config)
	{}

	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
		throws IOException,ServletException{
		PrintWriter out=response.getWriter();
	response.setContentType("text/html");

 		String fname=request.getParameter("FNAME");
		String lname=request.getParameter("LNAME");

		if(fname.equals(""))
			out.print(" Fname is Required...! ");
		else if(lname.equals(""))
			out.print(" Lname is Required ..! ");
		else
		 {
			out.print("<div style=border-style:dashed; border-color:red; font-size:10;>");
			out.print("<pre>");
			chain.doFilter(request,response);
			out.print("</pre>");
			out.print("</div>");
		 }

	out.close();
	}

	public void destroy()
	{}
}
*********************************************
StudentServlet.java
==================================
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class StudentServlet extends HttpServlet{
	public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		String fname=request.getParameter("FNAME");
		String lname=request.getParameter("LNAME");

		out.print("<h1> Fname : is "+fname);
		out.print("<h1> Lname is : "+lname);
		
		out.close();
	}

}
====================================
web.xml
====================================
<web-app>
<servlet>
   <servlet-name>F</servlet-name>
   <servlet-class>StudentServlet</servlet-class>
</servlet>
<servlet-mapping>
  <servlet-name>F</servlet-name>
  <url-pattern>/student.com</url-pattern>
</servlet-mapping>
<filter>
   <filter-name>S</filter-name>
   <filter-class>ValidateServlet</filter-class>
</filter>
<filter-mapping>
   <filter-name>S</filter-name>
   <url-pattern>/student.com</url-pattern>
</filter-mapping>
</web-app>