package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import model.course;


public class courseDAO {
	Connection connection = DBConnect.getConnection();

	public courseDAO() {
	}

	public List<course> selectAllCourses() {

		List<course> courses = new ArrayList<>();

		// Step 1: Establishing a Connection

		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_COURSES = "SELECT * FROM course";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int idCourse = rs.getInt(1);
				String name = rs.getString(2);
				String semester = rs.getString(3);
				String teacher = rs.getString(4);
				courses.add(new course(idCourse, name, semester, teacher));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	public course selectCourse(int idCourse) {
		course course = null;
		try {
			String SELECT_COURSE_BY_ID = "SELECT * FROM course WHERE idCourse = ? ";
			PreparedStatement ps = connection.prepareStatement(SELECT_COURSE_BY_ID);
			// input values from the form
			ps.setInt(1, idCourse);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String semester = rs.getString("semester");
				String teacher = rs.getString("teacher");
				course = new course(idCourse, name, semester, teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

	public void insertCourse(course course) throws SQLException {
		Connection connection = DBConnect.getConnection();
		try {
			String INSERT_COURSE = "INSERT INTO course" + "(name, semester, teacher) VALUES " + "(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_COURSE);
			ps.setString(1, course.getName());
			ps.setString(2, course.getSemester());
			ps.setString(3, course.getTeacher());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean updateCourse(course course) throws SQLException {
		boolean rowUpdated = false;
		try {
			String UPDATE_COURSE = "UPDATE course " + "SET name = ?, semester = ?, teacher = ? " + "WHERE idCourse = ?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_COURSE);
			ps.setString(1, course.getName());
			ps.setString(2, course.getSemester());
			ps.setString(3, course.getTeacher());
			ps.setInt(4, course.getIdCourse());

			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public boolean deleteCourse(int idCourse) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_COURSE = "DELETE FROM course " + "WHERE idCourse = ?";
			PreparedStatement ps = connection.prepareStatement(DELETE_COURSE);
			ps.setInt(1, idCourse);

			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
