package stream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.function.*;
import static java.util.stream.Collectors.*;

import static java.util.Comparator.*;

import stream.Student.Gender;

public class Examples {

	public static void main(String[] args) {
		
		Collection<Student> students = new LinkedList<>();
		students.add(new Student (100,"John","Smith",Gender.MALE));
		students.add(new Student (101,"Mary","Johnson",Gender.FEMALE));
		students.add(new Student (201,"Andrea","Rossi",Gender.MALE));
		students.add(new Student (202,"Giulia","Ferrari",Gender.FEMALE));
		students.add(new Student (301,"Mei","Wang",Gender.MALE));
		students.add(new Student (302,"Fang","Li",Gender.FEMALE));
		students.add(new Student (401,"Maria","Rossi",Gender.FEMALE));
		
		Course c1 = new Course ("02JEY", "Object-Oriented Programming");
		Course c2 = new Course ("02LAS", "Database");
		Course c3 = new Course ("02HGK", "Computer Newtworks");
		Course c4 = new Course ("01QZN", "Vizualization of Quantum Gravity");
		
		students.stream().forEach(c1::enroll);
		students.stream().limit(3).forEach(c2::enroll);
		students.stream().skip(2).limit(3).forEach(c3::enroll);
		
		//retrieve all female students
		Collection<Student> femaleStudents=
		students.stream().filter(s->s.getGender() == Student.Gender.FEMALE).collect(Collectors.toList());
		System.out.println(femaleStudents);
		
		
		//alternative
		femaleStudents=
		students.stream().filter(Student::isFemale).collect(Collectors.toList());
		System.out.println(femaleStudents);
		 
		//print in column 
		 
		//retrieve all students named john
		 
		 Collection<Student> namedJohn =
				 students.stream().filter(s->s.getFirst().equals("John")).collect(Collectors.toList());
		 System.out.println(namedJohn);
		 
		 //retrieve the collection of unique last name
		 Collection<String> lastName=
		 students.stream().map(Student::getLast).distinct().collect(Collectors.toList());
		 System.out.println(lastName);
		 
		 //alternative whit no .distinct()
		 
		 Collection<String> lastNameSet=
				 students.stream().map(Student::getLast).collect(Collectors.toSet());
		 System.out.println(lastNameSet);
		 
		 //ordered
		 
		 lastName=
				 students.stream().map(Student::getLast).collect(Collectors.toCollection(TreeSet::new));
		 System.out.println(lastName);
		 
		 // longest name
		 
		 Student longest= 
				 students.stream()
				 // .sorted(comparing(s->-s.getFirst().length()))     #alternative
				 .sorted(comparing(s->s.getFirst().length(),reverseOrder()))
				 .findFirst().get();
		 System.out.println(longest);
		 
		 
		 //retrieve students enroll in at least 2 courses
		 
		 Collection<Student> enrolledAtLeast2=
				 students.stream().filter(s->s.enrolledIn().size()>=2).collect(Collectors.toList());
		 System.out.println(enrolledAtLeast2);
		 
		 // how many students are enrolled to 2 or more courses
		 
		 long numAtLeast2=
				 students.stream().filter(s->s.enrolledIn().size()>=2).count();
		 System.out.println(numAtLeast2);
		 
		 //all courses with at least 1 student enrolled #with no course collection
		 
		 Collection<Course> attended=
				 students.stream().map(Student::enrolledIn).flatMap(Collection::stream)
				 .filter(c->c.enrolled().size()>1).collect(Collectors.toSet());
		 System.out.println(attended);
		 
		 //get maximum length of students last names
		 
		 int maxLength=
		 students.stream()
		 .mapToInt(s->s.getLast().length())
		 .max().getAsInt();
		 System.out.println(maxLength);
		 
		 //get String with list of sorted MALE first ";"
		 
		 String maleOrderedList=
				 students.stream().filter(Student::isMale).map(Student::getFirst).sorted().collect(Collectors.joining(";"));
		 System.out.println(maleOrderedList);
		 
		 //group students by gender
		 
		 Map<Student.Gender, List<Student>> byGender=
				 students.stream().collect(Collectors.groupingBy(Student::getGender));
		 System.out.println(byGender);
		 
		 //numbers of student by gender
		 
		 Map<Student.Gender, Long> countStudentsGender=
				 students.stream().collect(groupingBy(Student::getGender,counting()));
		 System.out.println(countStudentsGender);
		 
		 //group students by num of attended courses
		 
		 Map<Integer, List<Student>> studentByNumAttended=
				 students.stream().collect(groupingBy(s->s.enrolledIn().size()));
	}

}
