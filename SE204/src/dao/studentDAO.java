package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import model.student;

public class studentDAO {
	Connection connection = DBConnect.getConnection();
	public studentDAO() {
	}
	
	public List<student> selectAllStudents() {
		
		List<student> students = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		
		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_STUDENTS = "SELECT * FROM student";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String email = rs.getString(4);
				String phoneNumber = rs.getString(5);
				String sclass = rs.getString(6);
				students.add(new student(id, name, address, email, phoneNumber, sclass));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	
	// TO-DO: Implement selectUser() method to select user by ID (use in UPDATE
		// function)
		public student selectStudent(int id) {
			student student = null;
			try {
				String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ? ";
				PreparedStatement ps = connection.prepareStatement(SELECT_STUDENT_BY_ID);
				// input values from the form
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString("name");
					String address = rs.getString("address");
					String email = rs.getString("email");
					String phoneNumber = rs.getString("phoneNumber");
					String sclass = rs.getString("sclass");
					student = new student(id, name, address, email, phoneNumber, sclass);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		}

		// TO-DO: Implement insertUser() method to add new record to table User
		public void insertStudent(student student) throws SQLException {
			Connection connection = DBConnect.getConnection();
			try {
				String INSERT_STUDENT = "INSERT INTO student" + "(name, address, email, phoneNumber, sclass) VALUES " + "(?, ?, ?, ?, ?)";
				PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);
				ps.setString(1, student.getName());
				ps.setString(2, student.getAddress());
				ps.setString(3, student.getEmail());
				ps.setString(4, student.getPhoneNumber());
				ps.setString(5, student.getSclass());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// TO-DO: Implement updateUser() method to update record in table User
		public boolean updateStudent(student student) throws SQLException {
			boolean rowUpdated = false;
			try {
				String UPDATE_STUDENT = "UPDATE student " + "SET name = ?, address = ?, email = ?, phoneNumber = ?, sclass = ? " + "WHERE id = ?";
				PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT);
				ps.setString(1, student.getName());
				ps.setString(2, student.getAddress());
				ps.setString(3, student.getEmail());
				ps.setString(4, student.getPhoneNumber());
				ps.setString(5, student.getSclass());
				ps.setInt(6, student.getId());

				rowUpdated = ps.executeUpdate() > 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rowUpdated;
		}

		// TO-DO: Implement deleteUser() method to delete record in table User
		public boolean deleteStudent(int id) throws SQLException {
			boolean rowDeleted = false;
			try {
				String DELETE_STUDENT = "DELETE FROM student " + "WHERE id = ?";
				PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT);
				ps.setInt(1, id);

				rowDeleted = ps.executeUpdate() > 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rowDeleted;
		}
}
