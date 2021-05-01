package model;

public class course {
	protected int idCourse;
	protected String name;
	protected String semester;
	protected String teacher;
	
	public course() {
	}
	
	public course(String name, String semester, String teacher) {
		super();
		this.name = name;
		this.semester = semester;
		this.teacher = teacher;
	}
	
	public course(int idCourse, String name, String semester, String teacher) {
		super();
		this.idCourse = idCourse;
		this.name = name;
		this.semester = semester;
		this.teacher = teacher;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
