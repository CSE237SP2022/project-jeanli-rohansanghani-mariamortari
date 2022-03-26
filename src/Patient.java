
public class Patient {

	private String name;
	private int age;
	private String sex;
	private double weight; //in kilograms
	private double height; //in meters
	private int patient_id;
	
	public Patient(String name, int age, String sex, double weight, double height,int patient_id) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.weight=weight;
		this.height=height;
		this.patient_id =patient_id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public int getPatientId() {
		return patient_id;
	}
	
	public boolean isOverweight(){
		double overweight_bmi_index=25;
		double patient_body_mass_index=(weight)/(Math.pow(height,2));
		
		if (patient_body_mass_index>=overweight_bmi_index){
			return true;
		}
		
		return false;
		}
}
