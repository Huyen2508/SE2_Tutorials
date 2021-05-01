package Ex3;

public class Student {
	protected String name;
	protected String firstName;
	protected String lastName;
	
	public Student(String name) {
		this.setName(name);
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		int space =name.indexOf(' ');
		firstName = name.substring(0, space);
		lastName = name.substring(space+1);
		this.name = name;
	}
	
	public String toString() {
		return ("First Name: " + firstName + ", Last Name: " + lastName);
	}
}
