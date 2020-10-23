public class DriverClass {

	public static void main(String[] args) {

		Course CSE115 = new Course("CSE115", "Programming Language-I", 3, 6000);
		Course CSE173 = new Course("CSE173", "Discrete Mathematics", 3, 6000);
		Course CSE215 = new Course("CSE215", "Programming Language-II", 3, 6000);
		Course CSE225 = new Course("CSE225", "Data Structures and Algorithms", 3, 6000);
		Course CSE231 = new Course("CSE231", "Digital Logic Design", 3, 6000);
		Course CSE311 = new Course("CSE311", "Database Systems", 3, 6000);
		Course CSE323 = new Course("CSE323", "Operating Systems Design", 3, 6000);
		Course CSE373 = new Course("CSE373", "Design and Analysis of Algorithms", 3, 6000);

		Student s1 = new Student("Farhan Islam", 1631728042, 2.70, 'Y', 'N');
		Student s2 = new Student("Sadia Sultana", 1821347042, 3.44, 'N', 'Y');
		Student s3 = new Student("Sanjida Akter", 2021746042, 3.65, 'N', 'N');
		Student s4 = new Student("Farhan Bhuiyan", 1923147042, 3.94, 'N', 'N');
		Student s5 = new Student("Mahmudul Hoque", 1524137042, 2.14, 'Y', 'Y');

		Admin admin = Admin.getInstance(); // creating an Admin object

//SEGMENTS OF Assignment 3 INSTANTIATING STUDENT OBJECTS AND
//ADDING AND DROPPING COURSES ACCORDING TO THEIR CGPA.		
		s1.makeNewRegistration();
		s2.makeNewRegistration();
		s3.makeNewRegistration();
		s1.addCourse(CSE115);
		s1.addCourse(CSE173);
		s2.addCourse(CSE115);
		s2.addCourse(CSE215);
		s2.addCourse(CSE225);
		s3.addCourse(CSE115);
		s3.addCourse(CSE225);
		s3.addCourse(CSE311);
		admin.increaseSeatCapacity(CSE115, 5);
		s4.makeNewRegistration();
		s5.makeNewRegistration();
		s4.addCourse(CSE115);
		s4.addCourse(CSE225);
		s5.addCourse(CSE115);
		s5.addCourse(CSE173);
		s5.addCourse(CSE215);
// adding 4 more course to s3
		s3.addCourse(CSE173);
		s3.addCourse(CSE215);
		s3.addCourse(CSE231);
		s3.addCourse(CSE323); // THIS COURSE WONT BE ADDED BECAUSE S3 ALREADY REACHED 6 COURSE LIMIT
// adding 2 more course to s5
		s5.addCourse(CSE311);
		s5.addCourse(CSE373); // THIS COURSE WONT BE ADDED BECAUSE S3 ALREADY REACHED 4 COURSE LIMIT
		s3.dropCourse(CSE311);
		System.out.println("\n\n");

//		ASSIGNMENT 3 ENDS. 

//	************************* ASSIGNMENT 4 ********************************: 		
//	PREPARING BILLING INFO FOR THE STUDENTS):

		DevelopmentFeeCalculator devFee = new DevelopmentFeeCalculator();// CREATING OBJECTS OF DEVELOPMENTfeeCalculator
																			// CLASS AND BDTAX.
		BDTaxAdapter tax = new BDTaxAdapter();

		admin.setExtraFeeCalculator(devFee); // DEVELOPMENT FEES WILL BE CHARGED FOR S1 AND S2.

//	TASK 1 :	
		s1.setDiscount();
		s1.printBillingInfo();
		System.out.println("\n\n");
//	TASK 2:
		s2.setDiscount();
		s2.printBillingInfo();
		System.out.println("\n\n");
//	TASK 3:		

		admin.setExtraFeeCalculator(tax); // setExtraFee method is set to calculate BD tax by passing tax as a
											// parameter.
//TASK 4:		
		s3.setDiscount();
		s3.printBillingInfo();
		System.out.println("\n\n");
//	task 5:
		s4.setDiscount();
		s4.printBillingInfo();
		System.out.println("\n\n");
//	task 6:
		s5.setDiscount();
		s5.printRegistrationSlip(); // prints the complete slip with the courselist for student 5.
		System.out.println("\n\n");

	}

}
//SUBMITTED BY: CHOWDHURY NAFIS FAIYAZ_ID_1931841642_CSE215.9