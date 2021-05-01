package jersey.service;

import java.util.ArrayList;
import java.util.List;

import jersey.model.Course;

public class CourseService {
	public List<Course> getAllCourses() {
		Course s1 = new Course ("SE2", "Software Engineering", "Mr. Long");
		Course s2 = new Course ("NPR", "Network and Communication", "Mrs. Thao");
		Course s3 = new Course ("ISD", "Information Systems", "Mr. Ngoc");
	
		List<Course> list = new ArrayList<Course>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		return list;
	}
}
