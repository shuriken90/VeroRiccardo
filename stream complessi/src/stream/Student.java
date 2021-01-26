package stream;
import java.util.Collection;
import java.util.LinkedList;

public class Student {
	
	private int id;
	private String name;
	private String surname;
	private Collection <Course> courses;
	
	public static enum Gender {FEMALE,MALE}
	private Gender gender;
	
	public Student (int id, String n, String s) {
		this.id=id;
		this.name=n;
		this.surname=s;
		gender = Gender.MALE;
		courses = new LinkedList<Course>();
	}
	
	public Student (int id, String n, String s, Gender g) {
		this.id=id;
		this.name=n;
		this.surname=s;
		gender = g;
		courses = new LinkedList<Course>();
	}
	
	String getFirst() {return name;}
	String getLast() {return surname;}
	
	boolean isFemale() {return gender==Gender.FEMALE;}
	boolean isMale() {return gender==Gender.MALE;}
	
	public boolean matchFirst(String first) {
		return name.equals(first);
	}

	public void enrollIn(Course course) {
		courses.add(course);
		
	}
	
	public String toString() {
	
		return "("+id+") "+ surname + ", " + name;
		
	}
	
	public Gender getGender() {
		return gender;
	}

	public Collection<Course> enrolledIn() {
		return courses;
	}

}
