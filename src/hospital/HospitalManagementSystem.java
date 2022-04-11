package hospital;
import java.util.ArrayList;
import java.util.Scanner;


public class HospitalManagementSystem {
	
	private ArrayList<Patient> patientList;
	private boolean keepGoing;
	
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
		System.out.println("Select D to Delete Patient from the System");
		System.out.println("Select X to exit Hospital System");

		
		String input = in.nextLine();
		if(input.equals("A")) {
			addPatient();
		}
		if(input.equals("D")) {
			deletePatient();
		}
		if(input.equals("X")) {
			keepGoing = false;
		}
		
	}
	
	public void addPatient() {
		patientList.add(generatePatient());
		System.out.println("");
		System.out.println("");
		System.out.println("List of Patients in the System: ");
		printPatientList();
		
	}
	public void deletePatient() {
		if(patientList.isEmpty()) {
			System.out.println("Unable to remove patient since there are no patients currently in the system. Please add a patient to the system in order to execute this command.");
			System.out.println("");
			System.out.println("");
			menuControls();
		}else {
			Scanner in = new Scanner(System.in);
			System.out.println("Please type the ID number of the patient you wish to remove from the system");
			System.out.println("");
			System.out.println("");
			printPatientList();
			System.out.println("");
			System.out.println("");
			int id_patientToRemove = in.nextInt();
			patientList.removeIf(patient -> patient.getPatientId() == id_patientToRemove);
			
		}
		menuControls();
	}
	
	public void printPatientList() {
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
	
	public Patient generatePatient() {
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
	
	public int getPatientIDFromInput(Scanner in) {
		System.out.println("Enter Patient's ID");
		return in.nextInt();
	}
	
	
}
