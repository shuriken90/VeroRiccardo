package università;

public class University {
	
	private String name;
	private String rector;
	
	//costruttore
	public University(String name) {
		this.name = name;
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
	
	public Int enroll(String name, String last) {
		
		Student s = new Student(name,last);
		
		return 0;
	}

}
