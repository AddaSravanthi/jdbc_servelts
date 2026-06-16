package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDb
 */
@WebServlet("/ServletDb")
public class ServletDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletDb() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("id"));
		String pname=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sravanthi");
			PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?)");
			pst.setInt(1, pid);
			pst.setString(2, pname);
			pst.setDouble(3, price);
			pst.executeUpdate();
			response.setContentType("text/html");
			
			out.print("row created");
			out.print("<br></br>");
			pst.close();
			con.close();}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.print("<a href='index.html'>Go Back</a>");
		
	}

}
