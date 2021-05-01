package jersey.service;

import java.util.ArrayList;
import java.util.List;

import jersey.model.Student;

public class StudentService {
	public List<Student> getAllStudents() {
		Student s1 = new Student (1801040109, "Bui Huyen", "Ha Noi", "1801040109@s.hanu.edu.vn");
		Student s2 = new Student (1801040034, "Thu Dung", "Thai Binh", "1801040034@s.hanu.edu.vn");
		Student s3 = new Student (1801040030, "Thanh Huyen", "Hai Phong", "1801040030@s.hanu.edu.vn");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		return list;
	}
}
