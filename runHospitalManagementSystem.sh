#!/bin/bash

# Compile and run the program
javac -d bin src/hospital/*.java

java -cp bin hospital.HospitalManagementSystem

