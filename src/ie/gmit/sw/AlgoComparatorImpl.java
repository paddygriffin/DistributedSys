package ie.gmit.sw;

import ie.gmit.algorithms.DamerauLevenshtein;
import ie.gmit.algorithms.HammingDistance;
import ie.gmit.algorithms.Levenshtein;

public class AlgoComparatorImpl implements Runnable{

	private String str1;
	private String str2;
	private String option;
	private Resultator result;
	
	private Levenshtein ld = new Levenshtein();
	private HammingDistance hd = new HammingDistance();
	private DamerauLevenshtein dl = new DamerauLevenshtein();
	
	public AlgoComparatorImpl(String str1, String str2,Resultator result, String option) {
		this.str1 = str1;
		this.str2 = str2;
		this.result = result;
		this.option = option;
			
	}
	
	//Run method, essentially the main method of the runnable.
		public void run() {
			
			//Different algorithms return the result in different formats
			int distance;
			float distanceF;
			String distanceS;
			
			//Just simulating some work here
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			//Decide with string comparison algorithm to run. The code in each selection is basically the same
			if(option.equalsIgnoreCase("Levenshtein Distance")){
				
				distance = ld.distance(str1, str2);
				try {
					result.setResult("Levenshtein Distance is: "+distance);
					Thread.sleep(7000);//More processing done here
					result.setProcessed();//All done :)
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}//run
}
