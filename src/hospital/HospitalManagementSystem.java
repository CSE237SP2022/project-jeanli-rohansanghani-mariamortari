package hospital;
import java.util.ArrayList;
import java.util.Scanner;


public class HospitalManagementSystem {
	
	private ArrayList<Patient> patientList;
	private boolean keepGoing;
	private Scanner in;
	
	public HospitalManagementSystem(ArrayList<Patient> patientList, boolean keepGoing) {
		this.patientList = patientList;
		this.keepGoing = keepGoing;
		this.in = new Scanner(System.in);
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
		System.out.println("-------------------------------------------------------");
		System.out.println("Hospital Management System");
		System.out.println("Select L to List current Patients in the System");
		System.out.println("Select A to Add Patient to the System");
		System.out.println("Select S to Search for a Patient in the System");
		System.out.println("Select T to Add Lab Test Results for a Patient");
		System.out.println("Select W to Assess the BMI of a Patient");
		System.out.println("Select D to Delete Patient from the System");
		System.out.println("Select X to exit Hospital System");

		
		String input = in.nextLine();
		if(input.equals("L")) {
			printPatientList();
		}
		else if(input.equals("A")) {
			PatientGenerator generator = new PatientGenerator();
			Patient patient = generator.generatePatient();
			if(isPatientIdUnique(patient.getPatientId()) == false) {
				patient.setPatientId(patient.generatePatientId());
			} else {
				addPatient(patient);
			}
		}
		else if(input.equals("S")) {
			searchPatient();
    }
		else if(input.equals("T")) {
			enterLabTests();
		}
		else if(input.equals("W")) {
			Patient patient = getPatientFromId(getIdFromInput());
			if(patient != null) {
				System.out.println(patient.assessWeightClass());
			} else {
				System.out.println("Something went wrong. Make sure you entered a valid ID.");
			}
		}
		else if(input.equals("D")) {
			deletePatient(getIdFromInput());
		}
		else if(input.equals("X")) {
			keepGoing = false;
		}
		else {
			System.out.println("Invalid Input. Please try again.");
		}
		
	}
	
	public String getIdFromInput() {
		if(patientList.isEmpty()) {
			System.out.println("Unable to conduct this action since there are no patients currently in the system. Please add a patient to the system in order to execute this command.");
			System.out.println("");
			System.out.println("");
			return null;
		}else {
			printPatientList();
			System.out.println("");
			System.out.println("Please type the ID number of the patient you wish to conduct this action on from the system");
			String patientIdUserInput = Integer.toString(in.nextInt());
			return patientIdUserInput;
		}
	}
	public Patient getPatientFromId(String id) {
		Patient patient = null;
		for (Patient val: patientList) {
			if(val.getPatientId().equals(id)) {
				patient = val;
			}
		}
		return patient;
	}
	
	public void addPatient(Patient newPatient) {
		patientList.add(newPatient);
		printPatientList();
		
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
			String removedPatientName = patientList.get(indexDelete).getFirstName() + " " + patientList.get(indexDelete).getLastName();
			patientList.remove(indexDelete);
			System.out.println("Patient " + removedPatientName + " has been deleted from the system");
			System.out.println("");
			System.out.println("");
		}
	}
	
	public void printPatientList() {
		System.out.println("");
		System.out.println("");
		System.out.println("List of Patients in the System: ");
		if(patientList.size() > 0) {
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
		} else {
			System.out.println("There are no patients in the system.");
			System.out.println("");
			System.out.println("");
		}
	}
	
	public boolean isPatientIdUnique(String patientIdToCheckFor) {
		for(Patient patient:patientList) {
			if(patient.getPatientId().equals(patientIdToCheckFor)) {
				return false;
			}
		}
		return true;
	}
	public void enterLabTests() {
		System.out.println("Please type the ID number of the patient you wish to add lab test results for");
		String patientIdUserInput = Integer.toString(in.nextInt());
		for (Patient patient: patientList) {
			if(patient.getPatientId().equals(patientIdUserInput)) {
				System.out.println("Enter patient's heart rate in beats per minute");
				int beatsPerMin = in.nextInt();
				System.out.println("Enter patient's cholesterol in milligrams per deciliter");
				int cholesterol = in.nextInt();
				System.out.println("Enter patient's hemoglobin in grams per deciliter");
				int hemoglobin = in.nextInt();
				patient.setHeartRate(beatsPerMin);
				patient.setCholesterol(cholesterol);
				patient.setHemoglobin(hemoglobin);
				patient.printLabResults(patient);
			}
		}
	}
	
	public void searchPatient() {
		boolean found = false;
		System.out.println("Type the first name of the patient you wish to search for in the system");
		String searchPatientName = in.next();
		for( Patient patient:patientList) {
			if(patient.getFirstName().equals(searchPatientName)) {
				found=true;
				patient.toString();
			}
		}
		if(found == false) {
			System.out.println("There are no patients in the system with this name");
		}
		
		
	}
	
}
