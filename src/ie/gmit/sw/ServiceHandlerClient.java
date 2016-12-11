package ie.gmit.sw;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class ServiceHandlerClient implements Runnable {
	private BlockingQueue<Job> iq;
	private Resultator result;
	private StringService service;
	private Map<String, Resultator> oq;

	public ServiceHandlerClient(BlockingQueue<Job> inQueue, Map<String, Resultator> outQueue, StringService ss) {
		this.iq = inQueue;
		this.service = ss;
		this.oq = outQueue;
	}

	//Create a new thread
	public void run() {
		Job job = iq.poll();

		try {
			//Make the thread sleep for 10 seconds to slow the service down
			//to simulate a real asynchronous service.
			Thread.sleep(10000);
	
			//Send the strings and the algorithm to the StringService compare() method
			//Set the return value as a new instance of Resultator
			result = service.compare(job.getStr1(), job.getStr2(), job.getAlgo());
			
			//Add the Task Number and Resultator to the OutQueue
			oq.put(job.getTaskNumber(), result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
