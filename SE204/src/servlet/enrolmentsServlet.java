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

import dao.enrolmentsDAO;
import model.enrolments;

/**
 * Servlet implementation class enrolmentsServlet
 */
@WebServlet("/enrolments")
public class enrolmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private enrolmentsDAO enrolmentsDAO;

	private int selectedIdStudent;

	public void init() {
		enrolmentsDAO = new enrolmentsDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html); charser=UTF-8");
		request.setCharacterEncoding("utf-8");

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new": // show the form (front-end)
				showNewForm(request, response);
				break;
			case "/insert": // run SQL (back-end)
				insertEnrolment(request, response);
				break;
			case "/delete":
				deleteEnrolment(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEnrolment(request, response);
				break;
			default:
				listEnrolments(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void listEnrolments(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<enrolments> listEnrolments = enrolmentsDAO.selectAllEnrolments();
		request.setAttribute("listEnrolments", listEnrolments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("enrolment-list.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher("add-enrolment.jsp");
		dispatch.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int idStudent = Integer.parseInt(request.getParameter("idStudent"));
		selectedIdStudent = idStudent;
		enrolments existingEnrolment = enrolmentsDAO.selectEnrolment(idStudent);
		request.setAttribute("existingEnrolment", existingEnrolment);
		RequestDispatcher dispatch = request.getRequestDispatcher("edit-enrolment.jsp");
		dispatch.forward(request, response);
	}

	@SuppressWarnings("unused")
	private void insertEnrolment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int idStudent = Integer.parseInt(request.getParameter("idStudent"));
		int idCourse = Integer.parseInt(request.getParameter("idCourse"));
		String tutorialCode = request.getParameter("tutorialCode");
		enrolments newEnrolment = new enrolments(idStudent, idCourse, tutorialCode);
		enrolmentsDAO.insertEnrolment(newEnrolment);
		response.sendRedirect("list"); // redirect to page "enrolment list" after inserting new enrolment
	}

	@SuppressWarnings("unused")
	private void updateEnrolment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
//				int id = Integer.parseInt(request.getParameter("id"));
		int idCourse = Integer.parseInt(request.getParameter("idCourse"));
		String tutorialCode = request.getParameter("tutorialCode");
		enrolments newEnrolment = new enrolments(selectedIdStudent, idCourse, tutorialCode);
		enrolmentsDAO.updateEnrolment(newEnrolment);
		response.sendRedirect("list");
	}

	@SuppressWarnings("unused")
	private void deleteEnrolment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int idStudent = Integer.parseInt(request.getParameter("idStudent"));
		int idCourse = Integer.parseInt(request.getParameter("idStudent"));
		enrolmentsDAO.deleteEnrolment(idStudent, idCourse);
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
