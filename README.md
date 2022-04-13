# project-jeanli-rohansanghani-mariamortari
project-jeanli-rohansanghani-mariamortari created by GitHub Classroom

By: Jean Li, Maria Mortari, Rohan Sanghani

## 2nd Iteration

### What user stories were completed this iteration?

* User can choose to list current patients in the system
* User can delete a patient from the system
* User can assess the BMI of a patient in the system
* A unique patient ID is generated for each new patient added to the system, and this ID is used to select a specific patient for the above actions where needed.

### What user stories do you intend to complete next iteration?

* For the final iteration, we intend on creating new user stories to the Hospital Management System such as but not limited to

	* Implementing the appointment class so the user can make appointments for patients in the system
	
	* Search for a patient in the system
	
	* Store and check a patient's lab results
	

### Is there anything that you implemented but doesn't currently work?

* As of now, a basic appointment class was created but it has not been implemented yet. In other words, it exists but doesn't do anything yet. Implementing this class is a goal for the final iteration.

* As of now, when session in the Hospital Management System is terminated, all of the user's created operations in that same session (e.g. creation of new Patient, etc) are not stored 
	* We are trying to determine how to store all of a session's created operations so that once a new session is created, previously run operations can still be seen.


### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)

* Clone the repository into your local machine using <code> git clone url </code>

* Cd into the repository and run <code> ./runHospitalManagementSystem.sh </code>

* If you are unable to run the bash script, run <code> chmod 744 runHospitalManagementSystem.sh </code> and try again

* Once you get the program to run, you will start a new session in the Hospital Management System and the program will begin to prompt you for your input to perform tasks



