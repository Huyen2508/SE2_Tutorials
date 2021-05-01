package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import model.enrolments;

public class enrolmentsDAO {
	// Step 1: Establishing a Connection
			Connection connection = DBConnect.getConnection();
	public enrolmentsDAO() {
	}

	public List<enrolments> selectAllEnrolments() {

		List<enrolments> enrolments = new ArrayList<>();

		
		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_ENROLMENTS = "SELECT * FROM enrolments";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ENROLMENTS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int idStudent = rs.getInt(1);
				int idCourse = rs.getInt(2);
				String tutorialCode = rs.getString(3);
				enrolments.add(new enrolments(idStudent, idCourse, tutorialCode));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enrolments;
	}


	public enrolments selectEnrolment(int idStudent) {
		enrolments enrolment = null;
		try {
			String SELECT_ENROLMENT_BY_ID = "SELECT * FROM enrolments WHERE idStudent = ? ";
			PreparedStatement ps = connection.prepareStatement(SELECT_ENROLMENT_BY_ID);
			// input values from the form
			ps.setInt(1, idStudent);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idCourse = rs.getInt("idCourse");
				String tutorialCode = rs.getString("tutorialCode");
				enrolment = new enrolments(idStudent, idCourse, tutorialCode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrolment;
	}

	public void insertEnrolment(enrolments enrolment) throws SQLException {
		Connection connection = DBConnect.getConnection();
		try {
			String INSERT_ENROLMENT = "INSERT INTO enrolments" + "(idStudent, idCourse, tutorialCode) VALUES " + "(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_ENROLMENT);
			ps.setInt(1, enrolment.getIdStudent());
			ps.setInt(2, enrolment.getIdCourse());
			ps.setString(3, enrolment.getTutorialCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean updateEnrolment(enrolments enrolment) throws SQLException {
		boolean rowUpdated = false;
		try {
			String UPDATE_ENROLMENT = "UPDATE enrolment " + "SET idcourse = ?, tutorialCode = ? " + "WHERE idStudent = ?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_ENROLMENT);
			ps.setInt(1, enrolment.getIdCourse());
			ps.setString(2, enrolment.getTutorialCode());
			ps.setInt(3, enrolment.getIdStudent());
			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public boolean deleteEnrolment(int idStudent, int idCourse) throws SQLException {
		boolean rowDeleted = false;
		try {
			String DELETE_enrolment = "DELETE FROM enrolment " + "WHERE idStudent = ? AND idCourse = ?";
			PreparedStatement ps = connection.prepareStatement(DELETE_enrolment);
			ps.setInt(1, idStudent);
			ps.setInt(2, idCourse);

			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
