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
	void testGetPatientFromId() {
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60);
		patient1.setPatientId("1345");
		patientList.add(patient1);
		
		Patient patient2 = hospital.getPatientFromId("1345");
		
		assertTrue(patient1.equals(patient2));
		
	}
	
	//Other methods in the HospitalManagementClass not tested either just get an input from the user or just prints information.
	
}
