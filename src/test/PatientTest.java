package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hospital.Patient;

class PatientTest {
	
	
	private Patient p1;
	
	@BeforeEach
	void setup() {
		p1 = new Patient("bob","jones",36,"male",80.0,1.60,"1345");
	}
	
	@Test
	void testGetFirstName() {
		String firstName = p1.getFirstName();
		assertTrue("bob".equals(firstName));
	}
	
	@Test
	void testGetLastName() {
		String lastName = p1.getLastName();
		assertTrue("jones".equals(lastName));
	}
	
	@Test
	void testGetAge() {
		int age = p1.getAge();
		assertEquals(36,age);
	}
	
	@Test
	void testGetSex() {
		String sex = p1.getSex();
		assertTrue("male".equals(sex));
	}
	
	@Test 
	void testGetWeight() {
		double weight = p1.getWeight();
		assertEquals(80,weight,0.05);
	}
	
	@Test
	void testGetHeight() {
		double height = p1.getHeight();
		assertEquals(1.60,height,0.05);
	}
	
	@Test 
	void testGetPatientId() {
		String id = p1.getPatientId();
		assertEquals("1345",id);
	}
	
	@Test
	void testCalculateBMI() {
		double patientBMI = p1.calculateBMI();
		assertEquals(31.25,patientBMI,0.05);
	}

}