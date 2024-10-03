
public class Student extends Person {
	
	private double gpa = 0.0;
	
	public Student(double gpa) {
		
	}
	
	public void setGpa(double GPA) {
		gpa = GPA;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	@Override public void display() {
		
		System.out.println(super.getFirstName());
		System.out.println(super.getLastName());
		System.out.println(super.getAddress());
		System.out.println(getId());
		
	}

}
