package model;

public class enrolments {
	protected int idStudent;
	protected int idCourse;
	protected String tutorialCode;
	
	public enrolments() {
	}
	
	public enrolments(int idStudent, int idCourse, String tutorialCode) {
		super();
		this.idStudent = idStudent;
		this.idCourse = idCourse;
		this.tutorialCode = tutorialCode;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getTutorialCode() {
		return tutorialCode;
	}

	public void setTutorialCode(String tutorialCode) {
		this.tutorialCode = tutorialCode;
	}
}
