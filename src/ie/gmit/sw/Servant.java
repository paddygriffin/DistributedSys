package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servant {
	public static void main(String[] args) throws Exception{
		//Adapted from RMI_PassByReference lab
		
		
		//A string, representing the message we want to associate with our Message object
		String myMessage = "Hello from 10.2.2.65";
		
		//Create an instance of the class Message and pass the string as an argument to its constructor.
		StringService service = new StringServiceImpl();
		
		
		//Start the RMI regstry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-readable name "howdayService"
		Naming.rebind("howdayService", service);
		
		//Print a nice message to standard output
		System.out.println("Server ready.");
	}

}
