package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringService extends Remote {
	/*
where s and t are the two strings to compare, algo is the string matching algorithm to
use and Resultator is a remote object reference that allows the RMI service provider
to push an asynchronous response to the RMI requestor
	  */
	public Resultator compare(String s, String t, String algo) throws RemoteException;

}
