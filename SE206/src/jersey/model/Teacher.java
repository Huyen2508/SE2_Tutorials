package jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Teacher {
	private int teacherID;
	private String name;
	private String email;
	private String mobile;

	public Teacher() {
		super();
	}

	public Teacher(int teacherID, String name, String email, String mobile) {
		super();
		this.teacherID = teacherID;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}	
