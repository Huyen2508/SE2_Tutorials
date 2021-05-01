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

import dao.studentDAO;
import model.student;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/")
public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private studentDAO studentDAO;

	private int selectedId;
	
	public void init() {
		studentDAO = new studentDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
				insertStudent(request, response);
				break;
			case "/delete": 
				deleteStudent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			default:
				listStudent(request, response);	
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<student> listStudent = studentDAO.selectAllStudents();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showNewForm() method which navigates to ADD student view
		// (add-student.jsp)
		@SuppressWarnings("unused")
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatch = request.getRequestDispatcher("add-student.jsp");
			dispatch.forward(request, response);
		}

		// TO-DO: Implement showEditForm() method which navigates to UPDATE student view
		// (edit-student.jsp)
		@SuppressWarnings("unused")
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			selectedId = id;
			student existingStudent = studentDAO.selectStudent(id);
			request.setAttribute("existingStudent", existingStudent);
			RequestDispatcher dispatch = request.getRequestDispatcher("edit-student.jsp");
			dispatch.forward(request, response);
		}

		@SuppressWarnings("unused")
		private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phoneNumber");
			String sclass = request.getParameter("sclass");
			student newStudent = new student(name, address, email, phoneNumber, sclass);
			studentDAO.insertStudent(newStudent);
			response.sendRedirect("list"); //redirect to page "student list" after inserting new student
		}

		@SuppressWarnings("unused")
		private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phoneNumber");
			String sclass = request.getParameter("sclass");
			student updatedStudent = new student(selectedId, name, address, email, phoneNumber, sclass);
			studentDAO.updateStudent(updatedStudent);
			response.sendRedirect("list");
		}

		@SuppressWarnings("unused")
		private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			studentDAO.deleteStudent(id);
			response.sendRedirect("list");
		}
}
