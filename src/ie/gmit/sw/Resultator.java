package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

//remote interface exposes the public service methods that may be invoked by a remote object
public interface Resultator extends Remote {
	
	public String getResult() throws RemoteException;
	public void setResult(String result) throws RemoteException;
	public boolean isProcessed() throws RemoteException;
	public void setProcessed() throws RemoteException;

}
