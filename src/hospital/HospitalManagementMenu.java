package hospital;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HospitalManagementMenu {

	private boolean continueSession;
	private Scanner in = new Scanner(System.in);
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private HospitalManagementSystem hospital = new HospitalManagementSystem(patientList);
	
	public HospitalManagementMenu() {
		this.continueSession = true;
	}
	
	public static void main(String[] args) {
		HospitalManagementMenu menu = new HospitalManagementMenu();
		while(menu.continueSession) {
			menu.menuControls();
		}
	}
	public void assessPatientBMI() {
		Patient patient = hospital.getPatientFromId(hospital.getIdFromInput());
		if(patient != null) {
			System.out.println("This Patient's BMI is: " + patient.calculateBMI());
			System.out.println(patient.assessWeightClass());
		} else {
			System.out.println("Something went wrong. Make sure you entered a valid ID.");
		}
	}
	public void menuControls() {
		printMenuOptions();
		String input = in.nextLine();
		
		switch (input) {
		case "L": {hospital.printPatientList(); break;}
		case "A": {Patient newPatient = hospital.generatePatient(); hospital.addPatient(newPatient);break;}
		case "S": {hospital.searchPatient();break;}
		case "T": {hospital.enterLabTests();break;}
		case "W": {assessPatientBMI();break;}
		case "D": {hospital.deletePatient(hospital.getIdFromInput()); break;}
		case "X": { System.out.println("Hospital Management System Session Closed"); continueSession = false; break;}
		default: { System.out.println("Invalid Input. Please try again."); break;}
		}
	}
	
	public void printMenuOptions() {
		System.out.println("-------------------------------------------------------");
		System.out.println("Hospital Management System");
		System.out.println("Select L to List current Patients in the System");
		System.out.println("Select A to Add Patient to the System");
		System.out.println("Select S to Search for a Patient in the System");
		System.out.println("Select T to Add Lab Test Results for a Patient");
		System.out.println("Select W to Assess the BMI of a Patient");
		System.out.println("Select D to Delete Patient from the System");
		System.out.println("Select X to exit Hospital System");
	}

}
