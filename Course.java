
public class Course {

	private String id;
	private String title;
	private int credit;
	private int tutionPerCredit;
	private int numberofStudent=0;		//initial no. of students is 0 for every course
	private int seatCapacity=3 ;		//initial seat capacity for all courses is 3

//	course constructor
	public Course(String id, String title, int credit, int tutionPerCredit) {
		this.id=id;
		this.title=title;
		this.credit=credit;
		this.tutionPerCredit=tutionPerCredit;
		
	}
//	another constructor which only takes in the id.
	public Course(String id) {
		this.id=id;
		//this.title=null;
		
	}
//	getters
	public String getID() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getCredit() {
		return credit;
	}
	public int getNumberOfStudent() {
		return numberofStudent;
		
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public int getTutionPerCredit() {
		return tutionPerCredit;
	}
//	setters 
	public void setId(String id) {
		this.id=id;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setCredit(int credit) {
		this.credit=credit;
	}
	public void setNumberOfStudent(int numberofStudent) {
		this.numberofStudent=numberofStudent;
		
	}
	
//	add/remove number of student
	public void alterNoOfStudent(int student) {
		this.numberofStudent+=student;
	}
//	add/remove seats, by default seat is 3
	public void alterNoOfSeat(int seat) {
		this.seatCapacity+=seat;
	}
//	prints the course id seat capacity and number of students specifically (self defined method)
	public void printcourse() {
		System.out.println("Course id: "+ id+ " ,Seat capacity: "+seatCapacity+" ,Number of students: "+numberofStudent);
	}
	
//	this method returns a specific course fee .
	public int getSubTotal(){
		return credit*tutionPerCredit;
	}
	
	
//	to string method 
	@Override
	public String toString(){
		return "Course id: "+ id+", Course credit: "+credit+", Tution per credit: "+tutionPerCredit+", Number of students registered: "+numberofStudent+", Seat capacity: "+seatCapacity+"|";
	}
}
//SUBMITTED BY: CHOWDHURY NAFIS FAIYAZ_ID_1931841642_CSE215.9