package exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //1.JDBC ����̹� �ε�
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    //2. ������ ���̽��� ����
	    Connection con = null;
	    
	   	try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserc","jsp1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. SQL�� ����
	   	PreparedStatement pstmt = null;
	   	
	   	String sql = "select * from member";

	   	response.setContentType("text/html; charset=UTF-8");
	   	PrintWriter out = response.getWriter();
	   	
	   	try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			out.print("<table border=1");
			while(rs.next() == true){

				out.print("<tr>");

				out.print("<td>" + rs.getString("id") +"</td>");
				
				out.print("<td>" + rs.getString("name")+"</td>");
				

				out.print("<td>" + rs.getString("addr")+"</td>");
				out.print("<td>" +rs.getInt("age")+"</td>");

				out.print("<td>" +rs.getString("gender")+"</td>");

			//  out.print(rs.getString("pwd"));	
				out.print("</tr>");	

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}


/*
<table border=1>
	<tr>
		<td>ȫ�浿</td>
		<td>20</td>
	</tr>
</table> */