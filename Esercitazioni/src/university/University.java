package university;

import java.util.HashMap;
import java.util.Map;

public class University {
	
	private String name;
	private String rector;
	private Map<Integer, Student> students;
	private Map<Integer, Course> courses;
	private int id=10000;
	private int idC=10;
	
	//costruttore
	public University(String name) {
		this.name = name;
		students = new HashMap<>();
		courses = new HashMap<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setRector(String f, String l) {
		rector = f + " " + l;
	}
	
	public String getRector() {
		return rector;
	}
	
	public int enroll(String name, String last) {
		
		Student s = new Student(name,last,id);
		students.put(id, s);
		return id++;
	}

	public String student(int id) {
		return students.get(id).toString();
	}
	
	public int activate(String name, String prof) {
		Course c = new Course (name, prof, idC);
		courses.put(idC, c);
		return idC++;
	}
	
	public String course(int idC) {
		return courses.get(idC).toString();
	}
	
	public void register(int student, int course) {
		Student s= students.get(student);
		Course c = courses.get(course);
		s.attend(c);
		c.attended(s);
	}
	
	public String listAttendees(int idC) {
		return courses.get(idC).listAttendees();
	}
	
	public String studyPlan(int id) {
		return students.get(id).studyPlan();
	}

}
