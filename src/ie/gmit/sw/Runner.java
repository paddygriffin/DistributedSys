package ie.gmit.sw;

import java.rmi.RemoteException;

public class Runner {

	//Runner for Testing the StringService class without RMI
	public static void main(String[] args) throws RemoteException {
		//local Testing
		StringService ss = new StringServiceImpl();
		ss.compare("test", "Gareth", "Damerau-Levenshtein Distance");
		ss.compare("test", "Gareth", "Hamming Distance");
		ss.compare("test", "Testing", "Levenshtein Distance");
		ss.compare("test", "gareth", "JaroWinkler Distance");
	}//end main

}//end Runner