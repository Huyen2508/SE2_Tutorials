package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Reading the user's input
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		// Setting the content type
		res.setContentType("text/html");
		// Getting the stream to write the data
		PrintWriter pw = res.getWriter();
		// Writing html in the stream
		pw.println("<html>\n" + "<body>" + "<h2> Hello " + name + " !\n" + "</body>" + "</html>");
		// Closing the stream
		pw.close();
	}
}
