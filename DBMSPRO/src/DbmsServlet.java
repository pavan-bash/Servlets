import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class DbmsServlet extends HttpServlet
	{
		public void service(ServletRequest request, ServletResponse response) 
		throws ServletException,IOException
			{
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				
				//Regular business logic.
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager1");
					Statement st = con.createStatement();
					ResultSet rs1 = null;
					ResultSetMetaData rsmd1 = null;
					String temp1="", temp2="", temp3="", temp4="", temp5="";
					int nc1 = 0;

					//Request gathering parameter logic.
					try{temp1 = request.getParameter("name");}catch(Exception e){}
					try{temp2 = request.getParameter("dmat_ac_no");}catch(Exception e){}
					try{temp3 = request.getParameter("pan");}catch(Exception e){}
					try{temp4 = request.getParameter("share_id");}catch(Exception e){}
					try{temp5 = request.getParameter("company");}catch(Exception e){}
					
					if (temp1!=null)
					{
						rs1 = st.executeQuery("select c.name,c.dmat_ac_no,c.age,c.pan,c.contact,e.share_id,s.company_name,e.day,s.share_value,e.no_of_shares_owned from client c, exchange_board e, shares s where c.dmat_ac_no=e.dmat_ac_no and e.share_id=s.share_id and c.name='"+temp1+"'");
						rsmd1 = rs1.getMetaData();
						nc1 = rsmd1.getColumnCount();
					}
				
				else if (temp2!=null)
				{
					rs1 = st.executeQuery("select c.dmat_ac_no,c.name,c.age,c.pan,c.contact,e.share_id,s.company_name,e.day,s.share_value,e.no_of_shares_owned from client c, exchange_board e, shares s where c.dmat_ac_no=e.dmat_ac_no and e.share_id=s.share_id and c.dmat_ac_no='"+temp2+"'");
					rsmd1 = rs1.getMetaData();
					nc1 = rsmd1.getColumnCount();
				}
			
				else if(temp3!=null)
				{
					rs1 = st.executeQuery("select c.pan,c.name,c.dmat_ac_no,c.age,c.contact,e.share_id,s.company_name,e.day,s.share_value,e.no_of_shares_owned from client c, exchange_board e, shares s where c.dmat_ac_no=e.dmat_ac_no and e.share_id=s.share_id and c.pan='"+temp3+"'");
					rsmd1 = rs1.getMetaData();
					nc1 = rsmd1.getColumnCount();
				}

				else if(temp4!=null)
				{
					rs1 = st.executeQuery("select s.share_id,c.name,e.dmat_ac_no,c.age,c.contact,s.company_name,e.day,s.share_value,e.no_of_shares_owned from client c, exchange_board e, shares s where c.dmat_ac_no=e.dmat_ac_no and e.share_id=s.share_id and s.share_id='"+temp4+"'");
					rsmd1 = rs1.getMetaData();
					nc1 = rsmd1.getColumnCount();
				}
	
				else if(temp5!=null)
				{
					rs1 = st.executeQuery("select s.company_name,c.name,c.dmat_ac_no,c.age,c.pan,c.contact,e.share_id,e.day,s.share_value,e.no_of_shares_owned from client c, exchange_board e, shares s where c.dmat_ac_no=e.dmat_ac_no and e.share_id=s.share_id and s.company_name='"+temp5+"'");
					rsmd1 = rs1.getMetaData();
					nc1 = rsmd1.getColumnCount();
				}

					//Response
					String cssTag = "<link rel='stylesheet' type='text/css' href='src/dbms.css'>";
					out.print("<html>");
					out.print("<head>"+cssTag+"</head>");
					out.print("<body text=red><h1 align=center> EXCHANGE BOARD </h2><hr><br><br>");

					if(rs1.next())
					{
					out.print("<table align=center border=2>");
				
						out.print("<tr>");
						for(int c=1;c<=nc1;c++)
						{ 
							out.print("<th>"+rsmd1.getColumnName(c)+"</th>"); 
						}
						out.print("</tr>");

							out.print("<tr>");
							for(int c=1;c<=nc1;c++)
							{ 
								out.print	("<td>"+rs1.getString(c)+"</td>"); 
							}
							out.print("</tr>");

						while(rs1.next())
						{
							out.print("<tr>");
							for(int c=1;c<=nc1;c++)
							{ 
								out.print	("<td>"+rs1.getString(c)+"</td>"); 
							}
							out.print("</tr>");
						}
						
					out.print("</table>");
					}
					else
					{
						out.print("<h3 align='center'>NO RECORDS FOUND</h3>");
					}
					st.close();
					con.close();
				}//try
		
				catch(ClassNotFoundException cnfe)
				{
					out.print("<h2 align=center>"+cnfe+"</h2>");
				}//catch_1

				catch(SQLException se)
			    { 
					out.print("<h2 align=center>Unable to continue..."+se+"</h2>"); 
				}//catch_2

        out.print("</body>");
		out.print("</html>");
		out.close();
	}//service
}//class