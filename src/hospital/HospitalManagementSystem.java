package hospital;
import java.util.ArrayList;
import java.util.Scanner;


public class HospitalManagementSystem {
	
	private ArrayList<Patient> patientList;
	private Scanner in;
	
	public HospitalManagementSystem(ArrayList<Patient> patientList) {
		this.patientList = patientList;
		this.in = new Scanner(System.in);
	}
	
	public Patient generatePatient() {
		System.out.println("Enter Patient's First Name");
		String patientFirstName = in.next();
		System.out.println("Enter Patient's Last Name");
		String patientLastName = in.next();
		System.out.println("Enter Patient's Age");
		int patientAge = getIntFromInput();
		System.out.println("Enter Patient's Sex");
		String patientSex = in.next();
		System.out.println("Enter Patient's Weight (in kilograms)");
		double patientWeight = getDoubleFromInput();
		System.out.println("Enter Patient's Height (in meters)");
		double patientHeight = getDoubleFromInput();
		Patient patient = new Patient(patientFirstName,patientLastName,patientAge,patientSex,patientWeight,patientHeight);
		return patient;	
	}
	
	public int getIntFromInput() {
		while (!in.hasNextInt()) { 
			System.out.println("Enter integer values only");
			in.next();
		} 
		return in.nextInt();
	}
	
	public void assessPatientBMI() {
		Patient patient = getPatientFromId(getIdFromInput());
		if(patient != null) {
			System.out.println("This Patient's BMI is: " + patient.calculateBMI());
			System.out.println(patient.assessWeightClass());
		} else {
			System.out.println("Something went wrong. Make sure you entered a valid ID.");
		}
	}
	
	public double getDoubleFromInput() {
		while (!in.hasNextDouble()) { 
			System.out.println("Value not accepted. Please enter a number");
			in.next();
		} 
		return in.nextDouble();
	}
	
	public String getIdFromInput() {
		if(patientList.isEmpty()) {
			System.out.println("Unable to conduct this action since there are no patients currently in the system. Please add a patient to the system in order to execute this command.\n\n");
			return null;
		}else {
			printPatientList();
			System.out.println("\nPlease type the ID number of the patient you wish to conduct this action on from the system");
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
		if(isPatientIdUnique(newPatient.getPatientId())) {
			patientList.add(newPatient);
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
			String removedPatientName = patientList.get(indexDelete).getFirstName() + " " + patientList.get(indexDelete).getLastName();
			patientList.remove(indexDelete);
			System.out.println("Patient " + removedPatientName + " has been deleted from the system \n\n");
		}
	}
	
	public void printPatientList() {
		System.out.println("\n\nList of Patients in the System: ");
		if(patientList.size() > 0) {
			int counter = 1;
			for(Patient patient: patientList) {
				System.out.println(counter + ". ");
				System.out.println(patient.toString());
				counter += 1;
			}
		} else {
			System.out.println("There are no patients in the system.\n\n");
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
		if(patientList.isEmpty()) {
			System.out.println("Unable to conduct this action since there are no patients currently in the system. Please add a patient to the system in order to execute this command.\n\n");
		}
		else{
			System.out.println("Please type the ID number of the patient you wish to add lab test results for");
			String patientIdUserInput = Integer.toString(in.nextInt());
			for (Patient patient: patientList) {
				if(patient.getPatientId().equals(patientIdUserInput)) {
					System.out.println("Enter patient's heart rate in beats per minute");
					while (!in.hasNextInt()) { System.out.println("Enter integer values only");in.next();}
					patient.setHeartRate(in.nextInt());
					System.out.println("Enter patient's cholesterol in milligrams per deciliter");
					patient.setCholesterol(in.nextInt());
					System.out.println("Enter patient's hemoglobin in grams per deciliter");
					patient.setHemoglobin(in.nextInt());
					patient.printLabResults(patient);
				}
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
				System.out.println(patient.toString());
			}
		}
		if(found == false) {
			System.out.println("There are no patients in the system with this name");
		}
	}
	
	public void printLabTests() {
		if(patientList.isEmpty()) {
			System.out.println("Unable to conduct this action since there are no patients currently in the system. Please add a patient to the system in order to execute this command.\n\n");
		}
		else{
			for(Patient patient:patientList) {
				System.out.println((patientList.indexOf(patient)+1)+")");
				System.out.println(patient.toString());
				patient.printLabResults(patient);
			}
		}
		
	}
	
}
