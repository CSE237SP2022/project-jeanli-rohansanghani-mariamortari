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
	private Patient patient1;
	private Patient patient2;
	
	@BeforeEach 
	void setup() {
		patientList = new ArrayList<Patient>();
		hospital = new HospitalManagementSystem(patientList);
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

		assertTrue(isIdUnique);
		
	}
	
	@Test
	void testDeletePatient() {
		Patient patient = new Patient("bob","jones",36,"male",80.0,1.60);
		patientList.add(patient);
		
		int sizePatientListBeforeDeletion = patientList.size();
		hospital.deletePatient(patient.getPatientId());
		
		int sizePatientListAfterDeletion = patientList.size();

		assertEquals(sizePatientListAfterDeletion,sizePatientListBeforeDeletion-1);

	}
	@Test 
	// When using deletePatient(String patientId) method to delete a patient that is currently
	// not in the list, nothing happens and the size of patientList doesn't change
	void testDeletePatientThatDoesntExist() {
		Patient patient = new Patient("bob","jones",36,"male",80.0,1.60);
		patientList.add(patient);
		String patientID = patient.getPatientId();
		int sizeListBefore = patientList.size();
		
		String otherPatientId = "1234";
		hospital.deletePatient(otherPatientId);
		
		int sizeListAfter = patientList.size();
		
		assertEquals(sizeListBefore,sizeListAfter);
		assertTrue(!patientID.equals(otherPatientId));
		
	}
	
	@Test
	void testGetPatientFromId() {
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60);
		patient1.setPatientId("1345");
		patientList.add(patient1);
		
		Patient patient2 = hospital.getPatientFromId("1345");
		
		assertTrue(patient1.equals(patient2));
		
	}
	@Test 
	void testGeneratePatient() {
		System.out.println("\n ******BEGINNING OF A NEW TEST****** \n");
		System.out.println("FOR THIS TEST, PLEASE ANSWER THE PROMPTS BELOW TO CREATE A NEW PATIENT \n");
		Patient patient = hospital.generatePatient();
		
		//Tests if generatePatient() method is able to create an object of type 'Patient'
		assertTrue(patient!= null);
		assertTrue(patient.getClass() == Patient.class);
	}
	
	@Test
	void testEnterLabTests() {
		System.out.println("\n ******BEGINNING OF A NEW TEST****** \n");
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60);
		String patient1_ID = patient1.getPatientId();
		patientList.add(patient1);
		System.out.println("TO VERIFY THIS TEST ENTER THE FOLLOWING INFORMATION: \n ID NUMBER:"+patient1_ID+" \n HEART RATE:10 \n CHOLESTEROL:30 \n HEMOGLOBIN:50 ");
		hospital.enterLabTests();

		assertEquals(patient1.getHeartRate(),10);
		assertEquals(patient1.getCholesterol(),30);
		assertEquals(patient1.getHemoglobin(),50);
	}
	
	@Test
	// Hospital Management System will only add patient to the patientList if the patient
	// has a unique ID
	void testAddPatientsWithSameId() {
		patient1 =  new Patient("bob","jones",36,"male",80.0,1.60);
		patient1.setPatientId("1111");
		
		hospital.addPatient(patient1);
		
		int sizePatientListBefore = patientList.size();
		
		patient2 = new Patient("marie","terry",40,"female",70.0,1.90);
		patient2.setPatientId("1111");
		
		hospital.addPatient(patient2);
		
		int sizePatientListAfter = patientList.size();
		
		assertEquals(1,sizePatientListAfter);
		assertEquals(sizePatientListBefore,sizePatientListAfter);

	}
	@Test
	//If there is an attempt to add two patients with the same ID to the system, the system
	//will be able to accept only one patient with that ID, as no two patients can have 
	// the same id. Thus, the getPatientFromId() method should be able to return only one patient.  
	void testGetOnlyOnePatientFromId() {
		String sameId = "1111";
		patient1 =  new Patient("bob","jones",36,"male",80.0,1.60);
		patient1.setPatientId(sameId);
		
		patient2 = new Patient("marie","terry",40,"female",70.0,1.90);
		patient2.setPatientId(sameId);
		
		hospital.addPatient(patient1);
		hospital.addPatient(patient2);
		
		Patient retrievedPatient = hospital.getPatientFromId(sameId);
		
		assertEquals(patient1,retrievedPatient);
		
	}
	
	//Other methods in the HospitalManagementClass not tested either just get an input from the user or just prints information.
	
}
