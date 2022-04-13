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
	void testIsPatientIdUnique() {
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60,"1345");
		patientList.add(patient1);
		
		Patient patient2 = new Patient("josh","jones",56,"male",80.0,1.60,"1345");
		String patient2_ID = patient2.getPatientId();

		boolean isIdUnique = hospital.isPatientIdUnique(patient2_ID);

		assertEquals(false,isIdUnique);
		
	}
	
	@Test
	void testDeletePatient() {
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("TO VERIFY THIS TEST, ENTER 1345 WHEN PROMPTED");
		System.out.println("*********************************************");
		System.out.println("");
		
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60,"1345");
		patientList.add(patient1);
		
		int sizePatientListBeforeDeletion = patientList.size();
		hospital.deletePatient();
		
		int sizePatientListAfterDeletion = patientList.size();

		assertEquals(sizePatientListAfterDeletion,sizePatientListBeforeDeletion-1);

	}
	
	
	@Test
	void testGeneratePatient() {
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("TO VERIFY THIS TEST, ENTER THE FOLLOWING INFORMATION WHEN PROMPTED");
		System.out.println("First Name: bob");
		System.out.println("Last Name: jones");
		System.out.println("Age: 36");
		System.out.println("Sex: male");
		System.out.println("Weight: 80");
		System.out.println("Height: 1.6");
		System.out.println("*********************************************");
		System.out.println("");
		
		Patient patient1 = hospital.generatePatient();
		
		Patient patient2 = new Patient("bob","jones",36,"male",80,1.6,patient1.getPatientId());


	}
	
	@Test
	void testAddPatient() {
		int numberPatientsBefore = patientList.size();

		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("TO VERIFY THIS TEST, ENTER THE FOLLOWING INFORMATION WHEN PROMPTED");
		System.out.println("First Name: bob");
		System.out.println("Last Name: jones");
		System.out.println("Age: 36");
		System.out.println("Sex: male");
		System.out.println("Weight: 80");
		System.out.println("Height: 1.6");
		System.out.println("*********************************************");
		
		hospital.addPatient();
		
		int numberPatientsAfter = patientList.size();
		
		assertEquals(numberPatientsAfter,numberPatientsBefore+1);

		
	}


	@Test
	void testGetFirstNameFromInput() {
		System.out.println("Enter Bob");
		String firstName = hospital.getFirstNameFromInput(in);
		
		assertTrue(firstName.equals("Bob"));
	}
	
	@Test
	void testGetLastNameFromInput() {
		System.out.println("Enter Jones");
		String lastName = hospital.getLastNameFromInput(in);
		
		assertTrue(lastName.equals("Jones"));
	}
	
	@Test
	void testGetAgeFromInput() {
		System.out.println("Enter 30");
		int age = hospital.getAgeFromInput(in);
		
		assertEquals(30, age);
	}
	
	@Test
	void testGetSexFromInput() {
		System.out.println("Enter Male");
		String sex = hospital.getSexFromInput(in);
		
		assertTrue(sex.equals("Male"));
	}
	
	@Test
	void testGetWeightFromInput() {
		System.out.println("Enter 80");
		double weight = hospital.getWeightFromInput(in);
		
		assertEquals(80, weight, 0.05);
	}
	
	@Test
	void testGetHeightFromINput() {
		System.out.println("Enter 1.6");
		double height = hospital.getHeightFromInput(in);
		
		assertEquals(1.6, height, 0.05);
	}
	
	@Test
	void testGeneratePatientId() {
		String patientIdCreatedBySystem = hospital.generatePatientId();
		Patient p1 = new Patient("bob","jones",36,"male",80.0,1.60,patientIdCreatedBySystem);	
		assertEquals(patientIdCreatedBySystem, p1.getPatientId());
	}
	
	@Test
	void testAssessWeightClassUnderweight() {
		String weightClass = hospital.assessWeightClass(10.0);
		
		assertTrue(weightClass.equals("This patient is underweight."));
	}
	
	@Test
	void testAssessWeightClassOverweight() {
		String weightClass = hospital.assessWeightClass(30.0);
		
		assertTrue(weightClass.equals("This patient is overweight."));
	}
	
	@Test
	void testAssessWeightClass() {
		String weightClass = hospital.assessWeightClass(20.0);
		
		assertTrue(weightClass.equals("This patient is neither underweight nor overweight."));
	}

}
