package jersey.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.model.Teacher;
import jersey.service.TeacherService;

@Path("/teacher")
public class TeacherResource {
	TeacherService teacherService = new TeacherService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML) 
	public List<Teacher> getTeacher() {
		return teacherService.getAllTeachers();
	}
}
