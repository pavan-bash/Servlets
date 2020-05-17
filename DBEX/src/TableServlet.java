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

			ResultSetMetaData rsmd=rs.getMetaData();
			int nc=rsmd.getColumnCount();

			//Response
			String cssTag="<link rel='stylesheet' type='text/css' href='src/dbex.css'>";
			out.print("<html>");
			out.print("<head>"+cssTag+"</head>");
			out.print("<body text=red><h1 align=center> DBExample </h2><hr><br><br>");

			out.print("<table align=center border=2>");
				
				out.print("<tr>");
				for(int c=1;c<=nc;c++)
				{ out.print("<th>"+rsmd.getColumnName(c)+"</th>"); }
				out.print("</tr>");

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
			out.print("</html>");
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



