package jersey.service;

import java.util.ArrayList;
import java.util.List;

import jersey.model.Teacher;

public class TeacherService {
	public List<Teacher> getAllTeachers() {
		Teacher s1 = new Teacher (1, "Le Minh Duc", "duclm@hanu.edu.vn", "Hanu");
		Teacher s2 = new Teacher (2, "Nguyen Dinh Tran Long", "longndt@hanu.edu.vn", "Hanu");
		Teacher s3 = new Teacher (3, "Nguyen Van Cong", "congnv@hanu.edu.vn", "Hanu");
		Teacher s4 = new Teacher (4, "Dang Dinh Quan", "quandd@hanu.edu.vn", "Hanu");
		
		List<Teacher> list = new ArrayList<Teacher>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		return list;
	}
}
