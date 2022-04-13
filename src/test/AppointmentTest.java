package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hospital.Appointment;
import hospital.Patient;

class AppointmentTest {
	
	private Patient patient1;
	private Appointment appointment;
	
	@BeforeEach
	void setup() {
		patient1 = new Patient("bob","jones",36,"male",80.0,1.60,"1345");
		appointment = new Appointment(11, 12, "Eye test", patient1);
	}

	@Test
	void testGetDate() {
		
		int appointmentDate = appointment.getDate();
		
		int expectedAppointmentDate = 11;
		
		assertEquals(appointmentDate,expectedAppointmentDate);
		
	}
	@Test
	void testGetTime() {
		
		int appointmentTime = appointment.getTime();
		
		int expectedAppointmentTime = 12;
		
		assertEquals(appointmentTime,expectedAppointmentTime);
		
	}
	
	@Test
	void testGetType() {
		
		String appointmentType = appointment.getType();
		
		String expectedAppointmentType = "Eye test";
		
		assertEquals(appointmentType,expectedAppointmentType);
		
		
	}
	
	@Test
	
	void testGetInsurance() {
		
		appointment.setInsurance("Geico");
		
		String appointmentInsurance = appointment.getInsurance();
		
		assertEquals(appointmentInsurance,"Geico");
		

	}


}
