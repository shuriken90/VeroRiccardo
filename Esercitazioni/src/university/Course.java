package university;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;
	private String prof;
	private int idC;
	private List<Student> attended;
	
	public Course(String name, String prof, int idC) {
		this.name=name; this.prof=prof; this.idC=idC;
		attended = new ArrayList<>();
	}

	public String toString() {
		return "Course: " + getName() + ", " + getProf() + ", " + getIdC();
	}

	public String getName() {
		return name;
	}

	public String getProf() {
		return prof;
	}

	public int getIdC() {
		return idC;
	}

	public void attended(Student s) {
		attended.add(s);
	}
	
	public String listAttendees() {
		for (Student s : attended) {
			return s.toString();
		}
		return "No students attend this course;";
	}
	
}
