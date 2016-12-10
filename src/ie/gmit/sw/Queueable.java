package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

import ie.gmit.sw.Resultator;
import ie.gmit.sw.StringService;

public class Queueable {
	
	//Queues
	private BlockingQueue<Job> inQueue = new LinkedBlockingQueue<Job>();
	private ConcurrentMap<String, Resultator> outQueue = new ConcurrentHashMap<String, Resultator>();
	
	private StringService s;
	
	public Queueable(){
		try {
			rmiConnection();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		Queue();
	}
	
	public void Queue(){
		Job job;
		Resultator result;
		while(true){
		//Retrieves and removes the head of this queue, waiting if necessary until an element becomes available
		try {
			
			job = inQueue.take();
			//Make an RMI call to the String Comparison Service and gets Resultator back
			result = s.compare(job.getStr1(), job.getStr2(), job.getAlgo());
			
			//Job finished add Resultator to outQueue using the taskNumber as the key
            outQueue.put(job.getTaskNumber(), result);
			
			} catch (InterruptedException | RemoteException e) {
			e.printStackTrace();
			}
		}
	}
	
	
	//Connect to the RMI service
	private void rmiConnection() throws MalformedURLException, RemoteException, NotBoundException{
		//Connect to service running on localhost port 1099 with the name stringservice from the rmi registry
		s = (StringService) Naming.lookup("rmi://localhost:1099/stringservice");
	}

	//adds to inQueue
	public void add(Job j){
		inQueue.add(j);
	}//end add

	public boolean isComplete(String taskNumber) {
		if(outQueue.containsKey(taskNumber)){
			try{
				Resultator res = outQueue.get(taskNumber);
				return res.isProcessed();
			}
			catch (Exception e) {
			}
		}
		return false;
	}

	public String getResult(String taskNumber) {
		String jobResult = "";
		if(outQueue.containsKey(taskNumber)){
			try{
				Resultator res = outQueue.get(taskNumber);
				jobResult = res.getResult();
			}catch (Exception e) {
			}
		}
		return jobResult;
	}

}
