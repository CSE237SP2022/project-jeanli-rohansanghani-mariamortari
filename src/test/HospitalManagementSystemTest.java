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
	private Scanner in;
	
	@BeforeEach 
	void setup() {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		hospital = new HospitalManagementSystem(patientList, true);
		in = new Scanner(System.in);
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
	void testGetPatientIDFromInput() {
		System.out.println("Enter 123");
		int ID = hospital.getPatientIDFromInput(in);
		
		assertEquals(123, ID);
	}

}
