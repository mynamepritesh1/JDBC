package mypackage;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DemoJDBC
 */
@WebServlet("/DemoJDBC")
public class DemoJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			PrintWriter out =response.getWriter();//to write some text in the UI
			out.println("<html><body>");
			
			InputStream in =getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props= new Properties();
			props.load(in); // load the db connection data onto properties
			
			DBconnection conn = new DBconnection(props.getProperty("url"),props.getProperty("userid"),props.getProperty("password"));
			out.println("DB Connection Initialized. <br>");
			
			conn.closeConnection();
			out.println("DB Connection closed. <br>");
			
			out.println("<html><body>");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		
			
			
			
			
		}
	}
             
}
