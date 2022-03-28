package hospital;
import java.util.ArrayList;
import java.util.Scanner;


public class HospitalManagementSystem {
	
	public static ArrayList<Patient> patientList = new ArrayList<Patient>();
	static boolean keepGoing = true;

	public static void main(String[] args) {
		
		while(keepGoing) {
			menuControls();
		}
		if(keepGoing == false) {
			System.out.println("Hospital Management System Session Closed");
		}
		
	}
	
	public static void menuControls() {
		Scanner in = new Scanner(System.in);
		System.out.println("-------------------------------------------------------");
		System.out.println("Hospital Management System");
		System.out.println("Select A to Add Patient to the System");
		System.out.println("Select X to exit Hospital System");

		
		String input = in.nextLine();
		if(input.equals("A")) {
			addPatient();
		}
		if(input.equals("X")) {
			keepGoing = false;
		}
		
	}
	
	public static void addPatient() {
		patientList.add(generatePatient());
		System.out.println("");
		System.out.println("");
		System.out.println("List of Patients in the System: ");
		printPatientList();
		
	}
	
	public static void printPatientList() {
		int counter = 1;
		for(Patient val: patientList) {
			if(val!=null) {
				System.out.println(counter + ". ");
				System.out.println("Patient's Name =   " + "" + ((Patient) val).getFirstName() + "" + ((Patient) val).getLastName());
				System.out.println("Patient's Age =   " + "" + ((Patient) val).getAge());
				System.out.println("Patient's Sex =   " + "" + ((Patient) val).getSex());
				System.out.println("Patient's Weight (in kilograms) =   " + "" + ((Patient) val).getWeight());
				System.out.println("Patient's Height (in meters) =   " + "" + ((Patient) val).getHeight());
				System.out.println("Patient's ID =   " + "" + ((Patient) val).getPatientId());
				counter += 1;
				System.out.println("");
				System.out.println("");
			}
		}
	}
	
	public static Patient generatePatient() {
		Scanner in = new Scanner(System.in);
		
		String patientFirstName = getFirstNameFromInput(in);
		
		String patientLastName = getLastNameFromInput(in);
		
		int patientAge = getAgeFromInput(in);
		
		String patientSex = getSexFromInput(in);
		
		double patientWeight = getWeightFromInput(in);
		
		double patientHeight = getHeightFromInput(in);
		
		int patientID = getPatientIDFromInput(in);
		
		Patient patient = new Patient(patientFirstName,patientLastName,patientAge,patientSex,patientWeight,patientHeight,patientID);
		
		return patient;
		
	}
	
	
	public static String getFirstNameFromInput(Scanner in) {
		System.out.println("Enter Patient's First Name");
		return in.next();
	}
	
	public static String getLastNameFromInput(Scanner in) {
		System.out.println("Enter Patient's Last Name");
		return in.next();
	}
	
	public static int getAgeFromInput(Scanner in) {
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
	
	public static String getSexFromInput(Scanner in) {
		System.out.println("Enter Patient's Sex");
		return in.next();
	}
	
	public static double getWeightFromInput(Scanner in) {
		boolean inputANumber = false;
		double patientWeight = 0;
		while(!inputANumber) {
			System.out.println("Enter Patient's Weight (in kilograms)");
			if(in.hasNextInt()) {
				patientWeight = in.nextDouble();
				inputANumber = true;
			} else {
				String response = in.next();
				System.out.println(response + " is not a number");
			}
		}
		return patientWeight;
	}
	
	public static double getHeightFromInput(Scanner in) {
		boolean inputANumber = false;
		double patientHeight = 0;
		while(!inputANumber) {
			System.out.println("Enter Patient's Height (in meters)");
			if(in.hasNextInt()) {
				patientHeight = in.nextDouble();
				inputANumber = true;
			} else {
				String response = in.next();
				System.out.println(response + " is not a number");
			}
		}
		return patientHeight;
	}
	
	public static int getPatientIDFromInput(Scanner in) {
		System.out.println("Enter Patient's ID");
		return in.nextInt();
	}
	
	
}
