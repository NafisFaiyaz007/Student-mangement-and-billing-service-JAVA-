import java.util.ArrayList;

public class CurrentOfferedCourse {

//	Arraylist declaration
	ArrayList<Course> cList = new ArrayList<Course>(); // all the offered courses will be stored in the cList arrayList

//  blank constructor
	public CurrentOfferedCourse() {

	}

//	add course parameter to the array of the courses
	public void addCourse(Course course) {

		cList.add(course); // adds course using the inbuilt add method of arrayLists

	}

//  returns a course object if it is offered in a semester	(getter for course)
	public Course getCourse(Course course) {

		return course;
	}

//	returns an array of all the offered courses in a semester	
	public ArrayList<Course> getCourseList() {

		return cList;
	}
}

//SUBMITTED BY: CHOWDHURY NAFIS FAIYAZ_ID_1931841642_CSE215.9