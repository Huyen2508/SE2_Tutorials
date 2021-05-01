package jersey.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
	
	private String name;
	private String major;
	private String teacher;
	
	public Course() {
		super();
	}

	public Course(String name, String major, String teacher) {
		super();
		this.name = name;
		this.major = major;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
}
