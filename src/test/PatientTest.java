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
	
	@Test
	void testToString() {
		String patientInfo = p1.toString();
		String expected = "Patient's Name = bob jones" + "\n" + 
				"Patient's Age = 36" + "\n" +
				"Patient's Sex = male" + "\n" +
				"Patient's Weight = 80.0" + "\n" +
				"Patient's Height = 1.6" + "\n" +
				"Patient's ID = 1345";
		
		assertEquals(patientInfo, expected);
	}
	
	@Test
	void testAssessWeightClassUnderweight() {
		p1 = new Patient("bob","jones",36,"male",10.0,1.60,"1345");
		String weightClass = p1.assessWeightClass();
		
		assertTrue(weightClass.equals("This patient is underweight."));
	}
	
	@Test
	void testAssessWeightClassOverweight() {
		p1 = new Patient("bob","jones",36,"male",160.0,1.60,"1345");
		String weightClass = p1.assessWeightClass();
		
		assertTrue(weightClass.equals("This patient is overweight."));
	}
	
	@Test
	void testAssessWeightClass() {
		p1 = new Patient("bob","jones",36,"male",60.0,1.60,"1345");
		String weightClass = p1.assessWeightClass();
		
		assertTrue(weightClass.equals("This patient is neither underweight nor overweight."));
	}
}