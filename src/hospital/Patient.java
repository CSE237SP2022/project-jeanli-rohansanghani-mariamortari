package hospital;

public class Patient {

	private String firstName;
	private String lastName;
	private int age;
	private String sex;
	private double weight; //in kilograms
	private double height; //in meters
	private int patientID;
	
	public Patient(String firstName, String lastName, int age, String sex, double weight, double height,int patientID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.weight = weight;
		this.height = height;
		this.patientID = patientID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public int getPatientId() {
		return patientID;
	}
}
