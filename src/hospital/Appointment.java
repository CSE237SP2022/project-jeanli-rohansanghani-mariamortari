package hospital;

public class Appointment {
	
	private int date;
	private int time;
	private String type;
	private String insurance;
	private Patient patient;
	
	public Appointment(int date, int time, String type, Patient patient) {
		this.date = date;
		this.time = time;
		this.type = type;
		this.setInsurance(insurance);
		this.patient = patient;
	}
	
	public int getDate() {
		return date;
	}
	
	public int getTime() {
		return time;
	}
	
	public String getType() {
		return type;
	}
	
	public String getInsurance() {
		return insurance;
	}
	
	public Patient getPatient(){
		return patient;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

}