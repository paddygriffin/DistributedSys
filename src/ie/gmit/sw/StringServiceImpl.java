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
		
		//Compare Strings with StringComparator
		StringComparator comparator = new StringComparator(s, t, result, algo);
        
        //log out result
        System.out.println(result.getResult());

        //Returns the Resultator
		return result;
		
	}

}
