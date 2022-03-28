package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hospital.Patient;

class PatientTest {
	
	
	private Patient p1= new Patient("bob",36,"male",80.0,1.60,13);
	
	
	@Test
	void testGetName() {
		String name = p1.getName();
		assertTrue("bob".equals(name));
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
		assertEquals(80,weight);
	}
	
	@Test
	void testGetHeight() {
		double height = p1.getHeight();
		assertEquals(1.60,height);
	}
	
	@Test 
	void testGetPatientId() {
		double id = p1.getPatientId();
		assertEquals(13,id);
	}
	
	@Test
	void testCalculateBMI() {
		double patientBMI = p1.calculateBMI();
		assertEquals(31.25,patientBMI,0.05);
	}

}