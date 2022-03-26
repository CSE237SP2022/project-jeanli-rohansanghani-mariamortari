package hospital;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;


public class HospitalManagementSystem {
	
	public static ArrayList<Patient> patientList = new ArrayList<Patient>();
	static boolean keepGoing = true;

	public static void main(String[] args) {
		
		while(keepGoing) {
			menuControls();
		}
		if(keepGoing == false) {
			System.out.println("Hospital Management System Session Closed");
		}
		
	}
	public static void menuControls() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------------------------------------");
		System.out.println("Hospital Management System");
		System.out.println("Select A to Add Patient to the System");
		System.out.println("Select X to exit Hospital System");

		
		String str = scan.nextLine();
		if(str.equals("A")) {
			addPatient();
		}
		if(str.equals("X")) {
			keepGoing = false;
		}
		
		
	}
	public static void addPatient() {
		patientList.add(generatePatient());
		System.out.println("");
		System.out.println("");
		System.out.println("List of Patients in the System: ");
		printPatientList();
		
	}
	public static void printPatientList() {
		int counter = 1;
		for(Patient val: patientList) {
			if(val!=null) {
				System.out.println(counter+". ");
				System.out.println("Patient's Name =   "+""+((Patient) val).getName());
				System.out.println("Patient's Age =   "+""+((Patient) val).getAge());
				System.out.println("Patient's Sex =   "+""+((Patient) val).getSex());
				System.out.println("Patient's Weight (in kilograms) =   "+""+((Patient) val).getWeight());
				System.out.println("Patient's Height (in meters) =   "+""+((Patient) val).getHeight());
				System.out.println("Patient's ID =   "+""+((Patient) val).getPatientId());
				counter+=1;
				System.out.println("");
				System.out.println("");
			}
		}
		
	}
	public static Patient generatePatient() {
		Scanner scan2 = new Scanner(System.in);
		
		System.out.println("Enter Patient's Name");
		String p1_name = scan2.next();
		
		System.out.println("Enter Patient's Age");
		int p1_age = scan2.nextInt();
		
		System.out.println("Enter Patient's Sex");
		String p1_sex = scan2.next();
		
		System.out.println("Enter Patient's Weight (in kilograms)");
		double p1_weight = scan2.nextDouble();
		
		System.out.println("Enter Patient's Height (in meters)");
		double p1_height = scan2.nextDouble();
		
		System.out.println("Enter Patient's ID");
		int p1_id = scan2.nextInt();
		
		Patient pt = new Patient(p1_name,p1_age,p1_sex,p1_weight,p1_height,p1_id);
		
		return pt;
		
	}
	
	
}
