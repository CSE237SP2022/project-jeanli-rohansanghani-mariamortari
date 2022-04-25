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
	private int beatsPerMin;
	private int cholesterol; //in mg/dL
	private int hemoglobin; //in g/dL
	
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
