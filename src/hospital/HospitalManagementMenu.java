package hospital;

import java.util.ArrayList;
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
	public void menuControls() {
		printMenuOptions();
		String input = in.nextLine();
		
		switch (input) {
		case "L": {hospital.printPatientList(); break;}
		case "A": {Patient newPatient = hospital.generatePatient(); hospital.addPatient(newPatient);hospital.printPatientList();break;}
		case "S": {hospital.searchPatient();break;}
		case "T": {hospital.enterLabTests();break;}
		case "W": {hospital.assessPatientBMI();break;}
		case "D": {hospital.deletePatient(hospital.getIdFromInput()); break;}
		case "P": {hospital.printLabTests(); break;}
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
		System.out.println("Select P to Print Lab Test Results for all Patients in the System");
		System.out.println("Select X to exit Hospital System");
	}

}
