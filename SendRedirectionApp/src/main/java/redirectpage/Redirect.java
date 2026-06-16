package redirectpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirect
 */
@WebServlet("/Redirect")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Redirect() {
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
		int x=Integer.parseInt(request.getParameter("n1"));
		PrintWriter out=response.getWriter();
		if(x==1)
		{
			response.sendRedirect("https://www.youtube.com/");
		}
		else if(x==2)
		{
			response.sendRedirect("https://www.wikipedia.org/");
		}
		else if(x==3)
		{
			response.sendRedirect("https://www.geeksforgeeks.org/courses?source=google&medium=cpc&device=c&keyword=geeksforgeeks&matchtype=b&campaignid=20039445781&adgroup=147845288105&gad_source=1&gad_campaignid=20039445781&gbraid=0AAAAAC9yBkCEfxTTE4EoQJHVJFkMzoI0G&gclid=Cj0KCQjwof_QBhCgARIsADaMzOdf9ZyPPIzCnSopOAnv4iAPBJPIoAWXbOygFRbNcfX93eqB4wdVZbwaAnqQEALw_wcB");
		}
		else
		{
			out.print("invalid input");
		}
	}

}
