# project-jeanli-rohansanghani-mariamortari
project-jeanli-rohansanghani-mariamortari created by GitHub Classroom

By: Jean Li, Maria Mortari, Rohan Sanghani

## 1st Iteration

### What user stories were completed this iteration?

* User can add a new Patient to the Hospital Management System
* User can store information about the created Patient in the Hospital Management System
	* Patient's Name
	* Patient's Age
	* Patient's Sex
	* Patient's Weight
	* Patient's Height
	* Patient's ID Number
* After completing desired tasks, user can also terminate current session in the Hospital Management System 

### What user stories do you intend to complete next iteration?

* For the following iterations, we intend on creating new user stories to the Hospital Management System such as but not limited to

	* Creating appointments
	
	* Delete patient from the system
	
	* Search for a patient in the system
	
	* Store and check patient's lab results
	

### Is there anything that you implemented but doesn't currently work?

* As of now, if two or more Patients are created into the Hospital Management System with the same information (e.g. name, age, sex, patient id, etc), the System will treat them as two different Patients
	* We are actively working to implement necessary changes to bypass this concern for the next iteration

* As of now, when session in the Hospital Management System is terminated, all of the user's created operations in that same session (e.g. creation of new Patient, etc) are not stored 
	* We are trying to determine how to store all of a session's created operations so that once a new session is created, previously run operations can still be seen 


### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)

* At the root folder, run <code> ./runHospitalManagementSystem.sh </code>

* If you are unable to run the bash script, try <code> chmod 744 runHospitalManagementSystem.sh </code>

* Once you get the program to run, you will start a new session in the Hospital Management System and the program will begin to prompt you for your input to perform tasks



