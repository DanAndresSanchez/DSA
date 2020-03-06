package hashDriver;

/**
 * 
 * @author Dan Sanchez
 *
 */
public class Student {

	String name;
	String idNumber;
	int credits;
	HomeTown hometown;
	
	public Student(String name, String idNumber, int credit, HomeTown homeTown) {
		this.name = name;
		this.idNumber = idNumber;
		this.credits = credit;
		this.hometown = homeTown;
	}
	
	public boolean equals(Object other) {
		if(!(other instanceof Student))
			return false;
		Student student = (Student)other;
		if(student.name.equals(this.name) && student.credits == this.credits && student.hometown.equals(this.hometown))
			return true;
		return false;
	}

	public int hashCode() {
		return name.hashCode() + credits + hometown.hashCode();
	}
	
	public String toString() {
		return name+ "(" + idNumber + ")" + " " + credits + "cr" + hometown.toString();
	}
}
