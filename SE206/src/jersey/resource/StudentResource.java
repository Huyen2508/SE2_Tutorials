package jersey.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.model.Student;
import jersey.service.StudentService;

@Path("/student")
public class StudentResource {
	StudentService studentService = new StudentService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML) 
	public List<Student> getStudent() {
		return studentService.getAllStudents();
	}
}
