import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class DownloadServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        
PrintWriter out=response.getWriter();
response.setContentType
	("application/x-xls");

//Read Table Name From Combo Box [TABLE]
String table=request.getParameter("TABLE");

//DB Logic For Reading Data From selected Table
try{
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");

Statement st=con.createStatement();
ResultSet rs=
	st.executeQuery("SELECT * from "+table);
ResultSetMetaData rsmd=rs.getMetaData();
int nc=rsmd.getColumnCount();

out.print("<table>");

//Code for display Column Names
 out.print("<tr>");
    for(int c=1;c<=nc;c++)
	{ out.print
		("<th>"+rsmd.getColumnName(c)+"</th>"); }
 out.print("</tr>");

//code for column Data 
while(rs.next())
    {
out.print("<tr>");
   for(int col=1;col<=nc;col++)
		{ out.print("<td>"+rs.getString(col)+"</td>"); }
out.print("</tr>");
    }

out.print("</table>");

st.close();
con.close();
}
catch(Exception e)
		{ out.print("<h2 align=center>Unable to Process....: "+e+"</h2>"); }

        out.close();
	}
}