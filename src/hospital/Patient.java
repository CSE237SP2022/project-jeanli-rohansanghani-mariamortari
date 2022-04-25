package hospital;

public class Patient {

	private String firstName;
	private String lastName;
	private int age;
	private String sex;
	private double weight; //in kilograms
	private double height; //in meters
	private String patientID;
	private int beatsPerMin;
	private int cholesterol; //in mg/dL
	private int hemoglobin; //in g/dL
	
	
	public Patient(String firstName, String lastName, int age, String sex, double weight, double height,String patientID) {
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
	
	public String getPatientId() {
		return patientID;
	}
	
	public double calculateBMI(){
		double bmi = weight/(Math.pow(height, 2));
		return bmi;
	}
	
	public String toString() {
		return "Patient's Name = " + this.firstName + " " + this.lastName + "\n" + 
				"Patient's Age = " + this.age + "\n" +
				"Patient's Sex = " + this.sex + "\n" +
				"Patient's Weight = " + this.weight + "\n" +
				"Patient's Height = " + this.height + "\n" +
				"Patient's ID = " + this.patientID;
	}

	public void printPatient() {
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(age);
		System.out.println(sex);
		System.out.println(weight);
		System.out.println(height);
		System.out.println(patientID);
		System.out.println("");
		
	}

	public void setHeartRate(int beatsPerMin) {
		this.beatsPerMin = beatsPerMin;
	}
	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}
	public void setHemoglobin(int hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public int getHeartRate() {
		return this.beatsPerMin;
	}
	public int getCholesterol() {
		return this.cholesterol;
	}
	public int getHemoglobin() {
		return this.hemoglobin;
	}
	public void printLabResults(Patient patient) {
		System.out.println("Patient's heart rate: "+patient.getHeartRate());
		System.out.println("Patient's cholesterol: "+patient.getCholesterol());
		System.out.println("Patient's hemoglobin: "+patient.getHemoglobin());
		System.out.println("");
	}
	

}
