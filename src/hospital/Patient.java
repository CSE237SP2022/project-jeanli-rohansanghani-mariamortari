package hospital;

public class Patient {

	private String firstName;
	private String lastName;
	private int age;
	private String sex;
	private double weight; //in kilograms
	private double height; //in meters
	private String patientID;
	private double underweightThreshold = 18.4;
	private double overweightThreshold = 25.0;
	
	public Patient(String firstName, String lastName, int age, String sex, double weight, double height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.weight = weight;
		this.height = height;
		this.patientID = generatePatientId();
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
	
	public String assessWeightClass() {
		double BMI = this.calculateBMI();
		String weightClass = "Something went wrong.";
		if(BMI < underweightThreshold) {
			weightClass = "This patient is underweight.";
		} else if (BMI >= overweightThreshold) {
			weightClass = "This patient is overweight.";
		} else {
			weightClass = "This patient is neither underweight nor overweight.";
		}
//		System.out.println(weightClass);
		return weightClass;
	}
	
	public String generatePatientId() {
		String patient_Id="";
		for(int i=0;i<4;i++) {
			int randomNumber = (int)((Math.random() * 9) + 1);
			patient_Id=patient_Id+Integer.toString(randomNumber);
		}
		return patient_Id;
	}
	
	public void setPatientId(String ID) {
		this.patientID = ID;
	}

}
