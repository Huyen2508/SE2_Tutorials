package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.courseDAO;
import model.course;

/**
 * Servlet implementation class courseServlet
 */
@WebServlet("/course")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private courseDAO courseDAO;
	
	private int selectedIdCourse;

	public void init() {
		courseDAO = new courseDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html); charser=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new": // show the form (front-end)
				showNewForm(request, response);
				break;
			case "/insert": // run SQL (back-end)
				insertCourse(request, response);
				break;
			case "/delete": 
				deleteCourse(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCourse(request, response);
				break;
			default:
				listCourse(request, response);	
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void listCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<course> listCourse = courseDAO.selectAllCourses();
		request.setAttribute("listCourse", listCourse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher("add-course.jsp");
		dispatch.forward(request, response);
	}

	// TO-DO: Implement showEditForm() method which navigates to UPDATE course view
	// (edit-course.jsp)
	@SuppressWarnings("unused")
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int idCourse = Integer.parseInt(request.getParameter("idCourse"));
		selectedIdCourse = idCourse;
		course existingCourse = courseDAO.selectCourse(idCourse);
		request.setAttribute("existingCourse", existingCourse);
		RequestDispatcher dispatch = request.getRequestDispatcher("edit-course.jsp");
		dispatch.forward(request, response);
	}

	// TO-DO: Implement insertcourse() method for adding new course
	@SuppressWarnings("unused")
	private void insertCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String semester = request.getParameter("semester");
		String teacher = request.getParameter("teacher");
		course newCourse = new course(name, semester, teacher);
		courseDAO.insertCourse(newCourse);
		response.sendRedirect("list"); //redirect to page "course list" after inserting new course
	}

	// TO-DO: Implement updatecourse() method for updating existing course
	@SuppressWarnings("unused")
	private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String semester = request.getParameter("semester");
		String teacher = request.getParameter("teacher");
		course newcourse = new course(selectedIdCourse, name, semester, teacher);
		courseDAO.updateCourse(newcourse);
		response.sendRedirect("list");
	}

	// TO-DO: Implement deletecourse() method for deleting existing course
	@SuppressWarnings("unused")
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int idCourse = Integer.parseInt(request.getParameter("idCourse"));
		courseDAO.deleteCourse(idCourse);
		response.sendRedirect("list");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
