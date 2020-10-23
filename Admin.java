import java.util.ArrayList;

public class Admin {
	private IExtraFeeCalculator eFeeCalculator;

//	blank constructor
	public Admin() {

	}

//declaring arraylist of course type
	ArrayList<Course> courseOfferedinSemester = new ArrayList<>();

//takes a course of COURSE type from the user and adds it to the array list named offered course	
	public void offerCourse(Course course) {

		courseOfferedinSemester.add(course);
	}

//	prints all the courses offered in a semester with course id		
	public void publishOfferedCourse() {

		for (int i = 1; i < 9; i++) { // the first for loop prints the serial numbers.

			for (Course list : courseOfferedinSemester) { // enhanced for loop is used to print elements form the array
															// list
				System.out.print(i + ". ");
				System.out.println("Course Id: " + list.getID());
				i++;
			}
		}
	}

//	increases the seat capacity of the desired course
	public void increaseSeatCapacity(Course course, int size) {
		course.alterNoOfSeat(size - 3);
	}

	public void seeCourseStatus() {
//		prints all the offered courses with course id , number of students and seats
//		used a user-defined function called print course from the course class
		for (Course list : courseOfferedinSemester) {
			list.printcourse();
		}
	}

	public void setExtraFeeCalculator(IExtraFeeCalculator eFeeCalculator) {
		this.eFeeCalculator = eFeeCalculator;
	}

	public IExtraFeeCalculator getExtraFeeCalculator() {
		return eFeeCalculator;
	}

//this is used to set the type of extrafee to be charged.	
	private static Admin instance;

	public static Admin getInstance() {
		if (instance == null) {
			instance = new Admin();
		}
		return instance;
	}

}

//SUBMITTED BY: CHOWDHURY NAFIS FAIYAZ_ID_1931841642_CSE215.9