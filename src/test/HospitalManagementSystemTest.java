package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hospital.HospitalManagementSystem;
import hospital.Patient;

class HospitalManagementSystemTest {
	
	private HospitalManagementSystem hospital;
	private ArrayList<Patient> patientList;
	private Scanner in;
	
	@BeforeEach 
	void setup() {
		patientList = new ArrayList<Patient>();
		hospital = new HospitalManagementSystem(patientList, true);
		in = new Scanner(System.in);
	}
	@Test
	void testAddPatient() {
		int numberPatientsBefore = patientList.size();
		Patient newPatient = new Patient("bob","jones",36,"male",80,1.6);
		
		hospital.addPatient(newPatient);
		
		int numberPatientsAfter = patientList.size();
		
		assertEquals(numberPatientsAfter,numberPatientsBefore+1);
		
	}
	@Test
	void testIsPatientIdUnique() {
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60);
		patientList.add(patient1);
		
		Patient patient2 = new Patient("josh","jones",56,"male",80.0,1.60);
		String patient2_ID = patient2.getPatientId();

		boolean isIdUnique = hospital.isPatientIdUnique(patient2_ID);

		assertEquals(false,isIdUnique);
		
	}
	
	@Test
	void testDeletePatient() {
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60);
		patientList.add(patient1);
		
		int sizePatientListBeforeDeletion = patientList.size();
		hospital.deletePatient("1345");
		
		int sizePatientListAfterDeletion = patientList.size();

		assertEquals(sizePatientListAfterDeletion,sizePatientListBeforeDeletion-1);

	}
	
//	Arguably do not need to test because it is just a Scanner method. Testing the methods below this should be enough.
//	@Test
//	void testGeneratePatient() {
//		System.out.println("*********************************************");
//		System.out.println("*********************************************");
//		System.out.println("TO VERIFY THIS TEST, ENTER THE FOLLOWING INFORMATION WHEN PROMPTED");
//		System.out.println("First Name: bob");
//		System.out.println("Last Name: jones");
//		System.out.println("Age: 36");
//		System.out.println("Sex: male");
//		System.out.println("Weight: 80");
//		System.out.println("Height: 1.6");
//		System.out.println("*********************************************");
//		System.out.println("");
//		
//		Patient patient1 = hospital.generatePatient();
//		
//		Patient patient2 = new Patient("bob","jones",36,"male",80,1.6,patient1.getPatientId());
//
//		assertEquals(patient1.toString(), patient2.toString());
//	}

//	@Test
//	void testGetFirstNameFromInput() {
//		System.out.println("Enter Bob");
//		String firstName = hospital.getFirstNameFromInput();
//		
//		assertTrue(firstName.equals("Bob"));
//	}
//	
//	@Test
//	void testGetLastNameFromInput() {
//		System.out.println("Enter Jones");
//		String lastName = hospital.getLastNameFromInput();
//		
//		assertTrue(lastName.equals("Jones"));
//	}
//	
//	@Test
//	void testGetAgeFromInput() {
//		System.out.println("Enter 30");
//		int age = hospital.getAgeFromInput();
//		
//		assertEquals(30, age);
//	}
//	
//	@Test
//	void testGetSexFromInput() {
//		System.out.println("Enter Male");
//		String sex = hospital.getSexFromInput();
//		
//		assertTrue(sex.equals("Male"));
//	}
//	
//	@Test
//	void testGetWeightFromInput() {
//		System.out.println("Enter 80");
//		double weight = hospital.getWeightFromInput();
//		
//		assertEquals(80, weight, 0.05);
//	}
//	
//	@Test
//	void testGetHeightFromINput() {
//		System.out.println("Enter 1.6");
//		double height = hospital.getHeightFromInput();
//		
//		assertEquals(1.6, height, 0.05);
//	}
	
//	@Test
//	void testGeneratePatientId() {
//		String patientIdCreatedBySystem = hospital.generatePatientId();
//		Patient p1 = new Patient("bob","jones",36,"male",80.0,1.60,patientIdCreatedBySystem);	
//		
//		assertEquals(patientIdCreatedBySystem, p1.getPatientId());
//	}

}
