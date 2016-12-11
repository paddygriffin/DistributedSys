package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator {

	// Instance variables
	private static final long serialVersionUID = 1L;
	private String result;
	private boolean processed = false;
	private String s;
	private String t;
	
	//Constructor
		public ResultatorImpl() throws RemoteException{
		}
		
	// constructor from UnicastRemoteObject for stubs and skeletons
		public ResultatorImpl(String str1, String str2) throws RemoteException{
			this.s=str1;
			this.t=str2;
		}

	// Getters and Setters
	@Override
	public String getResult() throws RemoteException {
		return result;
	}

	@Override
	public void setResult(String result) throws RemoteException {
		this.result = result;
	}

	@Override
	public boolean isProcessed() throws RemoteException {
		return processed;
	}

	@Override
	public void setProcessed() throws RemoteException {
		this.processed = true;
	}

}
