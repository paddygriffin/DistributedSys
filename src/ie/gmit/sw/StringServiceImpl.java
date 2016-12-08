package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServiceImpl extends UnicastRemoteObject implements StringService {

	
	private static final long serialVersionUID = 1L;
	private Resultator result;

	//constructor
	protected StringServiceImpl() throws RemoteException {
	
	}

	@Override
	public Resultator compare(String s, String t, String algo) throws RemoteException {		
		result = new ResultatorImpl();
		
		AlgoComparatorImpl compareJob = new AlgoComparatorImpl(s, t, result, algo);
		
		return null;
		
	}

}
