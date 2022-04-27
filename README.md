# project-jeanli-rohansanghani-mariamortari
project-jeanli-rohansanghani-mariamortari created by GitHub Classroom

By: Jean Li, Maria Mortari, Rohan Sanghani

## 3rd Iteration


### What user stories were completed this iteration?

* User can search for patients in the system by first name
<br> <br />
* User can add lab test results for patients in the system
<br> <br />
	* Heart rate (in beats per minute)
<br> <br />
		* Cholesterol levels (in mg/dL)
<br> <br />
		* Hemoglobin levels (in g/dL)
<br> <br />
* User can print lab test results for all patients in the system
<br> <br />

### Is there anything that you implemented but doesn't currently work?

* A basic appointment class was created but it was not implemented. In other words, it exists but doesn't do anything. We ultimately decided to keep it this way for this iteration as we tried to address all of the feedback and suggestions from iteration 2 in regards to code cleanliness and formatting. Thus, in addition to creating additional user stories, our main focus during this iteration was to shorten our methods and make our classes as clean as possible. We specifically focused on cleaning up the 'HospitalManagementSystem' class which was very long and had methods that could be merged. In doing so, we created a new class called 'HospitalManagementMenu' to store all of the menu control options and related operations. If we were to continue working on this project, the implementation of Appointment would be the next thing that we would work on.
<br> <br />

* Our Hospital Management Menu class doesn't have unit tests because it essentially just gets an input from the user using scanner, calls on other methods, and prints statements. Additionally, when cleaning up our code, we removed unit tests for other methods that either just fetched an input from the user or printed information. Thus, the absence of unit tests for some methods, such as but not limited to printPatientList(), was intentional as these tests wouldn't have been useful in providing a valuable indication of how well our program performed.


### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)

* Clone the repository into your local machine using <code> git clone url </code>
<br> <br />
* Cd into the repository and run <code> ./runHospitalManagementSystem.sh </code>
<br> <br />
* If you are unable to run the bash script, run <code> chmod 744 runHospitalManagementSystem.sh </code> and try again
<br> <br />
* Once you get the program to run, you will start a new session in the Hospital Management System and the program will begin to prompt you for your input to perform tasks
<br> <br />


