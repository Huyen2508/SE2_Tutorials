package jersey.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.model.Course;
import jersey.service.CourseService;

@Path("/course")
public class CourseResource {
	CourseService courseService = new CourseService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML) 
	public List<Course> getCourse() {
		return courseService.getAllCourses();
	}
}
