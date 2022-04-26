package hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementMenu {

	private boolean continueSession;
	private Scanner in = new Scanner(System.in);
	
	public HospitalManagementMenu() {
		this.continueSession = true;
	}
	
	public static void main(String[] args) {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		HospitalManagementSystem hospital = new HospitalManagementSystem(patientList);
		
		HospitalManagementMenu menu = new HospitalManagementMenu();
		
		while(menu.continueSession) {
			menu.menuControls(hospital);
		}
		
	}
	
	public void menuControls(HospitalManagementSystem hospital) {
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
			hospital.printPatientList();
		}
		else if(input.equals("A")) {
			Patient newPatient = hospital.generatePatient();
			hospital.addPatient(newPatient);
		}
		else if(input.equals("S")) {
			hospital.searchPatient();
    }
		else if(input.equals("T")) {
			hospital.enterLabTests();
		}
		else if(input.equals("W")) {
			Patient patient = hospital.getPatientFromId(hospital.getIdFromInput());
			if(patient != null) {
				System.out.println("This Patient's BMI is: " + patient.calculateBMI());
				System.out.println(patient.assessWeightClass());
			} else {
				System.out.println("Something went wrong. Make sure you entered a valid ID.");
			}
		}
		else if(input.equals("D")) {
			hospital.deletePatient(hospital.getIdFromInput());
		}
		else if(input.equals("X")) {
			System.out.println("Hospital Management System Session Closed");
			continueSession = false;
		}
		else {
			System.out.println("Invalid Input. Please try again.");
		}
		
	}

}
