import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class PinfoServlet extends HttpServlet{
	public void service(ServletRequest request,
		ServletResponse response) throws ServletException,IOException	
	{
		 PrintWriter out=response.getWriter();
        //MIME type
		response.setContentType("text/html");

		//Req.p.logic Read Name | Gender | Age
		String name=request.getParameter("NAME");
		int age=Integer.parseInt
			(request.getParameter("AGE"));
		String gender=
			request.getParameter("GENDER");

		//R.B.Logic
		String status="";

		if(gender.equalsIgnoreCase("Male"))
		{
			if(age>=21)
				status="Major";
			else
				status="Minor";
		}
		else if(gender.equalsIgnoreCase("Female"))
		        {   
			         if(age>=18)
						 status="Major";
					 else
						 status="Minor";
		         }
		//Response
		out.print("<body background=n.jpg text=black>");

        out.print("<embed src=ne.mp3 start=auto hidden=true loop=3>");

		out.print("<h1 align=center> PInfo System <h1><hr><br><br>");

		out.print("<table align=center width=35%>");

		   out.print("<tr><td><h2>Name : </td><td>"+name+"</td></tr>");

		   out.print("<tr><td><h2>Gender : </td><td>"+gender+"</td></tr>");

		   out.print("<tr><td><h2>Age : </td><td>"+age+"</td></tr>");

		   out.print("<tr><td><h2>Status : </td><td>"+status+"</td></tr>");
		
		out.print("</table>");

		out.print("</body>");
		 out.close();
	}
}

