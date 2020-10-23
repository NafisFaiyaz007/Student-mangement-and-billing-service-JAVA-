import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Registration {
//		declaring course array	
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private ArrayList<IDiscountStrategy> applicableDiscounts = new ArrayList<IDiscountStrategy>();
	private IExtraFeeCalculator eFeeCalculator;

//		blank constructor	 
	public Registration() {

	}

//		this method adds a course given by the student to a students course list	 
	public void addCourse(Course course) {
		courseList.add(course);
	}

//		this deletes a course given by the student from the course list
	public void deleteCourse(Course course) {
		courseList.remove(course); // removes the desired course form the courselist array by using .remove method
		course.alterNoOfStudent(-1); // refreshes the total number of student by subrtacting 1 student
	}

//		this will return all the courses the student registered for the semester	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public String getLocalDateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	// it will return the total amount based on a students registered course.
	public double getTotal() {
		int total = 0;
		for (Course list : courseList) { // enters inside each courses in the course list and returns the amount of
											// money for each courses.

			total += list.getSubTotal();
		}
		double Total = total;
		return Total;
	}

//	it will return the extra fee that will be applied by the university depending on the semester
	public int getExtraFeeAmount() {

		Admin adminObject = Admin.getInstance();

		this.eFeeCalculator = adminObject.getExtraFeeCalculator();

		if (eFeeCalculator instanceof DevelopmentFeeCalculator) {

			return eFeeCalculator.getExtraAmount((int) this.getTotal());

		}
		if (eFeeCalculator instanceof BDTaxAdapter) {

			return eFeeCalculator.getExtraAmount((int) this.getTotal());

		} else
			return 0;

	}

//	it will return the grand total amount for a specific student.
	public int getGrandTotal() {
		double doubleExtraFee = getExtraFeeAmount();
		int extraFeeDouble = (int) doubleExtraFee;

		double doubleTotal = getTotal();
		int intTotalFee = (int) doubleTotal; // type casted from double to integer
		int sum = intTotalFee + extraFeeDouble;
		return sum;

	}

//	this method is used to add instances of discount classes to the arraylist<idiscountStrategy>
	public void setApplicableDiscounts(IDiscountStrategy discountStrategy) {

		applicableDiscounts.add(discountStrategy);

	}

//	this will return the discount amount for a student based on his status.
	public int getDiscountAmount() {

		int academicDiscount = 0;
		int freedomDiscount = 0;
		int minorityDiscount = 0;

		int max = 0;

		AcademicExcellenceDiscount Academic = new AcademicExcellenceDiscount();
		FreedomFighterDiscount Freedom = new FreedomFighterDiscount();
		MinorityGroupDiscount Minority = new MinorityGroupDiscount();

// the forloop will go throught the arraylist named applicable discount and will get the discounts availed by the student and store them in the designated variables.
		for (int i = 0; i < applicableDiscounts.size(); i++) {
			if (applicableDiscounts.get(i) instanceof AcademicExcellenceDiscount) {
				academicDiscount = Academic.getTotal(this);

			}
			if (applicableDiscounts.get(i) instanceof FreedomFighterDiscount) {
				freedomDiscount = Freedom.getTotal(this);

			}

			if (applicableDiscounts.get(i) instanceof MinorityGroupDiscount) {
				minorityDiscount = Minority.getTotal(this);

			}

		}

//this determines the maximum discount availed by the student and returns the maximum value.
		if (academicDiscount > minorityDiscount && academicDiscount > freedomDiscount) {
			max = academicDiscount;

		} else if (freedomDiscount > academicDiscount && freedomDiscount > minorityDiscount) {
			max = freedomDiscount;

		} else if (minorityDiscount > academicDiscount && minorityDiscount > freedomDiscount) {
			max = minorityDiscount;

		}
		return max;

	}

	public int getPayableAmount() {
		return this.getGrandTotal() - this.getDiscountAmount();
	}

}

//SUBMITTED BY: CHOWDHURY NAFIS FAIYAZ_ID_1931841642_CSE215.9
