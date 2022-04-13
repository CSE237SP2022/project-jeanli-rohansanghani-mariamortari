package hospital;
import java.util.ArrayList;
import java.util.Scanner;


public class HospitalManagementSystem {
	
	private ArrayList<Patient> patientList;
	private boolean keepGoing;
	private double underweightThreshold = 18.4;
	private double overweightThreshold = 25.0;
	
	public HospitalManagementSystem(ArrayList<Patient> patientList, boolean keepGoing) {
		this.patientList = patientList;
		this.keepGoing = keepGoing;
	}

	public static void main(String[] args) {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		HospitalManagementSystem hospital = new HospitalManagementSystem(patientList, true);
		
		while(hospital.keepGoing) {
			hospital.menuControls();
		}
		if(hospital.keepGoing == false) {
			System.out.println("Hospital Management System Session Closed");
		}
		
	}
	
	public void menuControls() {
		Scanner in = new Scanner(System.in);
		System.out.println("-------------------------------------------------------");
		System.out.println("Hospital Management System");
		System.out.println("Select A to Add Patient to the System");
		System.out.println("Select W to Assess the BMI of a Patient");
		System.out.println("Select D to Delete Patient from the System");
		System.out.println("Select X to exit Hospital System");

		
		String input = in.nextLine();
		if(input.equals("A")) {
			addPatient(generatePatient());
		}
		else if(input.equals("W")) {
			assessBMI();
		}
		else if(input.equals("D")) {
			deletePatient(getIdToDeleteFromInput());
		}
		else if(input.equals("X")) {
			keepGoing = false;
		}
		else {
			System.out.println("Invalid Input. Please try again.");
		}
		
	}
	
	public void addPatient(Patient newPatient) {
		patientList.add(newPatient);
		System.out.println("");
		System.out.println("");
		System.out.println("List of Patients in the System: ");
		printPatientList();
		
	}
	public String getIdToDeleteFromInput() {
		if(patientList.isEmpty()) {
			System.out.println("Unable to remove patient since there are no patients currently in the system. Please add a patient to the system in order to execute this command.");
			System.out.println("");
			System.out.println("");
			return null;
		}else {
			Scanner in = new Scanner(System.in);
			System.out.println("List of patients currently in the system:");
			printPatientList();
			System.out.println("");
			System.out.println("Please type the ID number of the patient you wish to remove from the system");
			String patientIdUserInput = Integer.toString(in.nextInt());
			return patientIdUserInput;
		}
	}
	public void deletePatient(String IdToDelete) {
		int indexDelete = 0;
		boolean changed =false;
		for(Patient patient:patientList) {
			if(patient.getPatientId().equals(IdToDelete)) {
				indexDelete = patientList.indexOf(patient);
				changed =true;
			}
		}if(changed) {
		patientList.remove(indexDelete);
		System.out.println("Patient has been deleted from the system");
		}
	}
	
	public void assessBMI() {
		if(patientList.isEmpty()) {
			System.out.println("Unable to assess patient since there are no patients currently in the system. Please add a patient to the system in order to execute this command.");
			System.out.println("");
			System.out.println("");
		}else {
			Scanner in = new Scanner(System.in);
			System.out.println("Please type the ID number of the patient you wish to assess the BMI of from the system");
			System.out.println("");
			System.out.println("");
			printPatientList();
			System.out.println("");
			System.out.println("");
			String id_patientToAssess = Integer.toString(in.nextInt());
			printBMI(id_patientToAssess);
		}
	}
	
	public void printBMI(String id) {
		for (Patient val: patientList) {
			if(val.getPatientId().equals(id)) {
				double BMI = val.calculateBMI();
				System.out.println("This patient has a BMI of " + BMI);
				System.out.println(assessWeightClass(BMI));
				System.out.println("");
				System.out.println("");
			}
		}
	}
	
	public String assessWeightClass(double BMI) {
		String weightClass = "Something went wrong.";
		if(BMI < underweightThreshold) {
			weightClass = "This patient is underweight.";
		} else if (BMI >= overweightThreshold) {
			weightClass = "This patient is overweight.";
		} else {
			weightClass = "This patient is neither underweight nor overweight.";
		}
		return weightClass;
	}
	
	public void printPatientList() {
		int counter = 1;
		for(Patient patient: patientList) {
			if(patient!=null) {
				System.out.println(counter + ". ");
				System.out.println(patient.toString());
				counter += 1;
				System.out.println("");
				System.out.println("");
			}
		}
	}
	
	public Patient generatePatient() {
		Scanner in = new Scanner(System.in);
		
		String patientFirstName = getFirstNameFromInput(in);
		String patientLastName = getLastNameFromInput(in);
		int patientAge = getAgeFromInput(in);
		String patientSex = getSexFromInput(in);
		double patientWeight = getWeightFromInput(in);
		double patientHeight = getHeightFromInput(in);
		String patientID = generatePatientId();
		Patient patient = new Patient(patientFirstName,patientLastName,patientAge,patientSex,patientWeight,patientHeight,patientID);
		
		return patient;
		
	}
	
	public String getFirstNameFromInput(Scanner in) {
		System.out.println("Enter Patient's First Name");
		return in.next();
	}
	
	public String getLastNameFromInput(Scanner in) {
		System.out.println("Enter Patient's Last Name");
		return in.next();
	}
	
	public int getAgeFromInput(Scanner in) {
		boolean inputAnInt = false;
		int patientAge = 0;
		while(!inputAnInt) {
			System.out.println("Enter Patient's Age");
			if(in.hasNextInt()) {
				patientAge = in.nextInt();
				inputAnInt = true;
			} else {
				String response = in.next();
				System.out.println(response + " is not an integer");
			}
		}
		return patientAge;
	}
	
	public String getSexFromInput(Scanner in) {
		System.out.println("Enter Patient's Sex");
		return in.next();
	}
	
	public double getWeightFromInput(Scanner in) {
		boolean inputANumber = false;
		double patientWeight = 0;
		while(!inputANumber) {
			System.out.println("Enter Patient's Weight (in kilograms)");
			if(in.hasNextDouble()) {
				patientWeight = in.nextDouble();
				inputANumber = true;
			} else {
				String response = in.next();
				System.out.println(response + " is not a number");
			}
		}
		return patientWeight;
	}
	
	public double getHeightFromInput(Scanner in) {
		boolean inputANumber = false;
		double patientHeight = 0;
		while(!inputANumber) {
			System.out.println("Enter Patient's Height (in meters)");
			if(in.hasNextDouble()) {
				patientHeight = in.nextDouble();
				inputANumber = true;
			} else {
				String response = in.next();
				System.out.println(response + " is not a number");
			}
		}
		return patientHeight;
	}
	
	public String generatePatientId() {
		String patient_Id="";
		for(int i=0;i<4;i++) {
			int randomNumber = (int)((Math.random() * 9) + 1);
			patient_Id=patient_Id+Integer.toString(randomNumber);
		}
		if(isPatientIdUnique(patient_Id)==false) {
			generatePatientId();
		}
		return patient_Id;
	}
	public boolean isPatientIdUnique(String patientIdToCheckFor) {
		for(Patient patient:patientList) {
			if(patient.getPatientId().equals(patientIdToCheckFor)) {
				return false;
			}
		}
		return true;
	}
	
	
}
