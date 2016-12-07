package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServiceImpl extends UnicastRemoteObject implements StringService {

	//constructor
	protected StringServiceImpl() throws RemoteException {
		super();
		
	}

	public Resultator compare(String s, String t, String algo) throws RemoteException {		
		return null;
	}

}
