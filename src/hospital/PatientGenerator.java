package hospital;

import java.util.Scanner;

public class PatientGenerator {
	
	private Scanner in = new Scanner(System.in);

	public Patient generatePatient() {
		System.out.println("Enter Patient's First Name");
		String patientFirstName = in.next();
		System.out.println("Enter Patient's Last Name");
		String patientLastName = in.next();
		int patientAge = getAgeFromInput();
		System.out.println("Enter Patient's Sex");
		String patientSex = in.next();
		double patientWeight = getWeightFromInput();
		double patientHeight = getHeightFromInput();
		Patient patient = new Patient(patientFirstName,patientLastName,patientAge,patientSex,patientWeight,patientHeight);
		
		return patient;	
	}
	
	public int getAgeFromInput() {
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
	
	public double getWeightFromInput() {
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
	
	public double getHeightFromInput() {
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
}
