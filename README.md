# DistributedSys
## An Asynchronous Java RMI String Comparison Service
- Student Name: Patrick Griffin
- Student ID: G00314635
- Module: Distributed Systems
- Lecturer: Dr. John Healy

### Introduction
The project is a Java RMI String comparison service, 
which is meant to get user input from web browser and calculate the distance
between the given string by the choosen algorithm. 
The RMI service is an application written using Java RMI technology

### Running the application
To run this application:
cmd prompt
cd into the located string-service.jar file and run the command:
java –cp ./string-service.jar ie.gmit.sw.Servant

To then run the application:
Locate your apache tomcat folder and drag the "comparator.war" file
into the webapps folder

Then run the startup.bat file through the cmd prompt or normally and you should receive a
popup window of Tomcat.

If you get an error saying the JAVA_HOME environmental variable is not set up
follow this tutorial and make sure you close down cmd prompts and re-open them to get it running

Once both have been started, open op a Web Browser and paste in the Url: http://localhost:8080/comparator

Here is my example:

![alt text](https://cloud.githubusercontent.com/assets/10612598/21084249/9997822e-bff8-11e6-9062-99fbd4edfa13.PNG "Example")
![alt text](https://cloud.githubusercontent.com/assets/10612598/21084250/99989542-bff8-11e6-9d5f-fd0f70775f71.PNG "Example")

### UML DIAGRAM
![alt text](https://cloud.githubusercontent.com/assets/10612598/21084251/9998e0ce-bff8-11e6-83bd-33dbedbb515a.PNG "Example")



