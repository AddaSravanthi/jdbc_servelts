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
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservlet() {
        super();
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
		PrintWriter out = response.getWriter();

		int pid = Integer.parseInt(request.getParameter("id"));
		String pname = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbc",
					"root",
					"sravanthi");

			PreparedStatement pst = con.prepareStatement(
					"update product set pname=?, price=? where pid=?");

			pst.setString(1, pname);
			pst.setDouble(2, price);
			pst.setInt(3, pid);

			int rows = pst.executeUpdate();

			response.setContentType("text/html");

			if (rows > 0) {
				out.println("Record Updated Successfully");
			} else {
				out.println("No Record Found with ID " + pid);
			}

			out.println("<br><br>");
			out.println("<a href='index.html'>Go Back</a>");

			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
