
public class Student {

	private String name;
	private int id;
	private double cgpa;
	private Registration reg;
	private char freedomFighterStatus;
	private char minorityGroupStatus;

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public Registration getReg() {
		return reg;
	}

	public void setReg(Registration reg) {
		this.reg = reg;
	}

	public void setFreedomFighterStatus(char x) {
		freedomFighterStatus = x;
	}

	public char getFreedomFighterStatus() {
		return freedomFighterStatus;
	}

	public void setMinorityStatus(char x) {
		minorityGroupStatus = x;

	}

	public char getMinortyStatus() {
		return minorityGroupStatus;
	}
//	student constructor

	public Student(String name, int id, double cgpa, char freedomFighterStatus, char minorityGroupStatus) {
		this.name = name;
		this.id = id;
		this.cgpa = cgpa;
		this.freedomFighterStatus = freedomFighterStatus;
		this.minorityGroupStatus = minorityGroupStatus;
	}

//	making new registration of class type REGISTRATION
	public void makeNewRegistration() {
		reg = new Registration();
	}

//	this method adds courses according to the student cgpa and seat availability
	public void addCourse(Course course) {

		if (course.getNumberOfStudent() != course.getSeatCapacity()) { // will execute this if statement until the no of
																		// students reaches 3 which is = the defaault
																		// seat capacity

			if (this.cgpa >= 3.5) { // will execute this if clause when student cgpa is > 3.5.

				while (reg.getCourseList().size() <= 6) { // the loop will continue until the size of the courselist
															// array becomes 6courses(18 credits).

					if (reg.getCourseList().size() == 6) { // when the course list size becomes 6 then it gives the
															// student a warning.
						System.out.println(
								getName() + ": You cannot take " + course.getID() + ". You exceeded 18 credits limit");

						break;
					} else { // or else it adds the course using the add course method of the registration
								// class.
						reg.addCourse(course);
						course.alterNoOfStudent(1); // increases the number of students by 1 everytime a course is added
						break;
					}
				}
			}

			else if (this.cgpa < 3.5) { // executes when cgpa is < 3.5

				while (reg.getCourseList().size() <= 4) { // the loop will continue until the size of the courselist
															// array becomes 4courses(12 credits).

					if (reg.getCourseList().size() == 4) { // when the course list size becomes 4 then it gives the
															// student a warning.
						System.out.println(
								getName() + ": You cannot take " + course.getID() + ". You exceeded 12 credits limit");

						break;
					} else { // or else it adds the course using the add course method of the registration
								// class.
						reg.addCourse(course);
						course.alterNoOfStudent(1);
						break;
					}
				}
			}
		}

		else // when the no. of students = to the number of seats available then this else
				// clause is executed.
		{ // more students can take that course only if the seats are increased by the
			// admin class.
			System.out.println(course.getID() + " cannot be added. Seat is Full !!");
		}
	}

//	method for dropping course
	public void dropCourse(Course course) {

		reg.deleteCourse(course); // from registration class
		course.alterNoOfStudent(-1); // decreases the number of student by 1 after dropping the course.

	}

//	this method return the registration object of a student created during makeRegistration method call(getter of reg)
	public Registration getRegistration() {
		return reg;
	}

	public void printRegisteredCourse() { // prints the final course list of a student
		// reg.getCourseList();
		System.out.println("Course ID:	Course Title");
		System.out.println("===============================================");
		for (Course list : reg.getCourseList()) {
			System.out.println(list.getID() + "		" + list.getTitle());
		}
		System.out.println("===============================================");
	}

//	It will set different discounts applicable for a student	
	public void setDiscount() {

		if (this.getFreedomFighterStatus() == 'Y') {
			reg.setApplicableDiscounts(new FreedomFighterDiscount());
		}
		if (this.getMinortyStatus() == 'Y') {
			reg.setApplicableDiscounts(new MinorityGroupDiscount());
		}
		if (this.getCgpa() > 3.5) {
			reg.setApplicableDiscounts(new AcademicExcellenceDiscount());
		}

	}

//	it will return the breakdown of the bill
	public String getBillingInfo() {
		return "Billing Info:	( ID: " + this.id + " )" + "\n" + "-----------------------------------------------"
				+ "\n" + "Total Course Fees: 	" + reg.getTotal() + "\n" + "Extra Fees:	  +	 "
				+ reg.getExtraFeeAmount() + "\n" + "-----------------------------------------------" + "\n"
				+ "Grand Total:		" + reg.getGrandTotal() + "\n" + "Discount:	  --	 " + reg.getDiscountAmount()
				+ "\n" + "-----------------------------------------------" + "\n" + "Payable Amount:		"
				+ reg.getPayableAmount();
	}

	public void printBillingInfo() {
		System.out.println(getBillingInfo());
	}

//	this method prints all the basic information of a student including the billing info and courses registered for.
	public void printRegistrationSlip() {
		System.out.println("Registration Time: " + reg.getLocalDateTime());
		System.out.println("-----------------------------------------------");
		System.out.println("Name:" + this.name + ", ID: " + this.id + ", CGPA: " + this.cgpa);
		System.out.println();
		System.out.println("-----------------------------------------------");
		printRegisteredCourse();
		System.out.println("===============================================");
		System.out.println(getBillingInfo());
	}

//	to string
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", cgpa=" + cgpa + ", freedomFighterStatus="
				+ freedomFighterStatus + ", minorityGroupStatus=" + minorityGroupStatus + "]";
	}

}
//SUBMITTED BY: CHOWDHURY NAFIS FAIYAZ_ID_1931841642_CSE215.9