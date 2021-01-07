package university;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	
	private String name;
	private String last;
	private int id;
	private List<Course> attend;
	
	
	public Student(String name, String last, int id) {
		this.name = name; this.last = last; this.id=id;
		attend = new ArrayList<>();
	}
	
	public String toString () {
		return "Student: " + getName() + ", " + getLast() + ", " + getId(); 
	}


	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLast() {
		return last;
	}

	public void attend(Course c) {
		attend.add(c);
	}
	
	public String studyPlan() {
		for (Course c : attend) {
			return c.toString();
		}
		return "This student does not attend any course;";
	}
	
}
