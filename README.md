# JavaApachePOI
# Steps to Follow:
1. Navigate to the local working dir path
2. Use git clone command to execute this project. git clone
3. Navigate to src/main/java and run the "ReadExcel.java" class file as java application.
4. Navigate to src/test/java and run the "MakemyTrip_Application" class file as java application.
5. Results can be viewed in console.

#TestNG:
1. Run maven command "mvn clean test" from command line after navigating to the working directory or right click pom.xml file and add configuration under Maven by setting up the necessary projects. Add goal as "clean test".
2.TESTNG HTML reports are found under target/surefire-reports folder.

#Cucumber Framework:
1.Navigate to src/test/java and run the "RunnerTest" class file as junit test.
2.To run through maven, kindly remove the testng dependency and under maven-surefire-plugin removed the configuration part. Right click the pom.xml file and run as maven test.Or Run maven command "mvn clean test" from command line.
3.Cucumber html reports are found under target/cucumber-reports folder.

Note: Under src/main/resources folder , git commands used for this project is being captured as screenshot.