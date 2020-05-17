DBEX1
============================
table.html
=============================
<html>
  <body bgcolor=green text=white>
     <form action="table.com" method="post">
	    <h1 align=center> DBExample </h1>
		<hr><br><br>
		<table align=center>
		    <tr><td><h2>Enter Tablename :</td>
			       <td><input type="text" name="TABLE"></td>
				   <td><input type="submit" value="GetData"></td></tr>
		</table>	    
	 </form>
  </body>
</html>
**********************************************
TableServlet.java
==================================
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class TableServlet extends HttpServlet{
	public void service(ServletRequest request,
		ServletResponse response) 
		throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		//Req.p.logic
		String table=
			request.getParameter("TABLE");

		//DBLogic
		try{
			Class.forName
				("oracle.jdbc.driver.OracleDriver");
			
			Connection con=
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");

			Statement st=con.createStatement();
			ResultSet rs=
			st.executeQuery("SELECT * from "+table);

			ResultSetMetaData rsmd=
				rs.getMetaData();
			int nc=rsmd.getColumnCount();

			//Response
			out.print("<body bgcolor=green text=white><h1 align=center> DBExample </h2><hr><br><br>");

			out.print("<table align=center border=2>");
			    while(rs.next())
			     {
					out.print("<tr>");
					  for(int c=1;c<=nc;c++)
					  { out.print
						  ("<td>"+rs.getString(c)+"</td>"); 
					  }
					out.print("</tr>");
				 }
			out.print("</table>");
			st.close();
			con.close();
		}//try
		
		catch(ClassNotFoundException cnfe){
			out.print
				("<h2 align=center>"+cnfe+"</h2>");
		}//catch_1

		catch(SQLException se)
	    { out.print("<h2 align=center>Unable to continue..."+se+"</h2>"); 
		}//catch_2

        out.print("</body>");
		out.close();
	}//service
}//class
****************************************
web.xml
==============================
<web-app>
  <welcome-file-list>
     <welcome-file>table.html</welcome-file>
  </welcome-file-list>
  <servlet>
     <servlet-name>S</servlet-name>
	 <servlet-class>TableServlet</servlet-class>
  </servlet>
  <servlet-mapping>
     <servlet-name>S</servlet-name>
	 <url-pattern>/table.com</url-pattern>
  </servlet-mapping>
</web-app>



