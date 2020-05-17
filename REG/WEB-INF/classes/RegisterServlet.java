import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class RegisterServlet extends HttpServlet{
	public void service(ServletRequest request,ServletResponse response)
		throws ServletException,IOException
	{
      PrintWriter out = response.getWriter();
	  response.setContentType("text/html");

	  //Reg.g.p.logic(dno,dname,loc)
	int dno=
	Integer.parseInt(request.getParameter("DNO"));
	String dname=request.getParameter("DNAME");
	String dloc=request.getParameter("DLOC");

	//DBLogic
	try{
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con=
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");

PreparedStatement pst=
	con.prepareStatement("INSERT INTO DEPT VALUES(?,?,?)");

pst.setInt(1,dno);
pst.setString(2,dname);
pst.setString(3,dloc);

pst.executeUpdate();

out.print("<body bgcolor=yellow text=red>");
out.print("<h1 align=center> Registe Application </h1><hr><br><br>");

out.print("<h2 align=center>"+dno+"| "+dname+"| "+dloc+" Registered....! </h2>");

pst.close();
con.close();

	}
catch(SQLException | ClassNotFoundException e)
{
	out.print("<h2 align=center>Unable to continue...."+e+"</h2>");
}

      out.print("</body>");
	  out.close();
	}
}