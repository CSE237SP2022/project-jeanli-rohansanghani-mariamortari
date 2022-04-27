package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hospital.Patient;

class PatientTest {
	
	
	private Patient p1;
	
	@BeforeEach
	void setup() {
		p1 = new Patient("bob","jones",36,"male",80.0,1.60);
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
	void testSetPatientId() {
		p1.setPatientId("1345");
		
		assertEquals(p1.getPatientId(), "1345");
	}
	
	@Test
	void testCalculateBMI() {
		double patientBMI = p1.calculateBMI();
		assertEquals(31.25,patientBMI,0.05);
	}
	
	@Test
	void testToString() {
		String patientInfo = p1.toString();
		String expected = "Patient's Name = " + "bob" + " " + "jones" + "\n" + 
		"Patient's Age = " + 36 + "\n" +
		"Patient's Sex = " + "male" + "\n" +
		"Patient's Weight = " + "80.0" + "\n" +
		"Patient's Height = " + "1.6" + "\n" +
		"Patient's ID = " + p1.getPatientId() + "\n";
		
		assertEquals(patientInfo, expected);
	}
	
	@Test
	void testAssessWeightClassUnderweight() {
		Patient p2 = new Patient("bob","jones",36,"male",45.0,1.60);
		
		String weightClass = p2.assessWeightClass();
		
		assertTrue(weightClass.equals("This patient is underweight."));
	}
	
	@Test
	void testAssessWeightClassOverweight() {
		String weightClass = p1.assessWeightClass();
		
		assertTrue(weightClass.equals("This patient is overweight."));
	}
	
	@Test
	void testAssessWeightClassNeither() {
		Patient p2 = new Patient("bob","jones",36,"male",50,1.50);

		String weightClass = p2.assessWeightClass();
		
		assertTrue(weightClass.equals("This patient is neither underweight nor overweight."));
	}
	
	@Test
	//Makes sure that generated patient id is valid and contains characters
	void testGeneratePatientId() {
		String generatedId = p1.generatePatientId();
		
		assertTrue(!generatedId.equals(""));
	}
	
	@Test
	//Patients created with the same identifying information are still attributed unique ID values
	//and are considered unique
	void testPatientIdsAreUnique() {
		Patient patient1 = new Patient("bob","jones",36,"male",80.0,1.60);
		Patient patient2 = new Patient("bob","jones",36,"male",80.0,1.60);
		Patient patient3 = new Patient("bob","jones",36,"male",80.0,1.60);
		Patient patient4 = new Patient("bob","jones",36,"male",80.0,1.60);
		
		String patient1_ID = patient1.getPatientId();
		String patient2_ID = patient2.getPatientId();
		String patient3_ID = patient3.getPatientId();
		String patient4_ID = patient4.getPatientId();
		
		assertTrue(!patient1_ID.equals(patient2_ID));
		assertTrue(!patient1_ID.equals(patient3_ID));
		assertTrue(!patient1_ID.equals(patient4_ID));
		assertTrue(!patient2_ID.equals(patient3_ID));
		assertTrue(!patient2_ID.equals(patient4_ID));
		assertTrue(!patient3_ID.equals(patient4_ID));
	}
	
	@Test
	void testSetHeartRate() {
		int heartRate = 150 ; 
		p1.setHeartRate(heartRate);
		
		assertEquals(heartRate,p1.getHeartRate());
	}
	@Test
	void testSetCholesterol() {
		int cholesterol = 200 ; 
		p1.setCholesterol(cholesterol);
		
		assertEquals(cholesterol,p1.getCholesterol());
	}
	@Test
	void testSetHemoglobin() {
		int hemoglobin = 300 ; 
		p1.setHemoglobin(hemoglobin);
		
		assertEquals(hemoglobin,p1.getHemoglobin());
	}
	@Test
	// Heart Rate should be 0 initially, since it hasn't been set yet
	void testGetHeartRateInitially() {
		int heartrate = p1.getHeartRate();
		
		assertTrue(heartrate==0);
	}
	@Test
	// Heart rate value should only change from 0 when it is set to another value by the user
	void testGetHeartRateAfterSet() {
		int heartRateInitial = p1.getHeartRate();
		int heartRateAfter = 100; 

		p1.setHeartRate(heartRateAfter);
		
		assertTrue(heartRateInitial!=p1.getHeartRate());
		assertEquals(heartRateAfter,p1.getHeartRate());
	}
	// Cholesterol should be 0 initially, since it hasn't been set yet
	@Test
	void testGetCholesterolInitially() {
		int cholesterol = p1.getCholesterol();
		
		assertTrue(cholesterol==0);
		
	}
	@Test
	// Cholesterol value should only change from 0 when it is set to another value by the user
	void testGetCholesterolAfterSet() {
		int cholesterolInitial = p1.getCholesterol();
		int cholesterolAfter = 300; 

		p1.setCholesterol(cholesterolAfter);
		
		assertTrue(cholesterolInitial!=p1.getCholesterol());
		assertEquals(cholesterolAfter,p1.getCholesterol());
	}
	// Hemoglobin should be 0 initially, since it hasn't been set yet
	@Test
	void testGetHemoglobinInitially() {
		int hemoglobin = p1.getHemoglobin();
		
		assertTrue(hemoglobin==0);
		
	}
	// Hemoglobin value should only change from 0 when it is set to another value by the user
	@Test
	void testGetHemoglobinAfterSet() {
		int hemoglobinInitial = p1.getHemoglobin();
		int hemoglobinAfter = 500; 

		p1.setHemoglobin(hemoglobinAfter);
		
		assertTrue(hemoglobinInitial!=p1.getHemoglobin());
		assertEquals(hemoglobinAfter,p1.getHemoglobin());
	}
	
	@Test
	// Patient ID can be changed from its original value that was generated by the system
	void testChangePatientId() {
		String originalPatientId = p1.getPatientId();
		
		String newId = "1111";
		p1.setPatientId(newId);
		
		String updatedPatientId = p1.getPatientId();
		
		assertTrue(!originalPatientId.equals(updatedPatientId));
		assertEquals(newId,updatedPatientId);
	}
	
	
	
	
	
	
	//Other methods in the Patient class do not have tests because either they just print information or are getters/setters
}