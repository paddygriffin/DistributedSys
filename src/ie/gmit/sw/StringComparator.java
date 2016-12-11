package ie.gmit.sw;


import ie.gmit.algorithms.*;
import java.rmi.RemoteException;

public class StringComparator implements Runnable{

	private String s;
	private String t;
	private Resultator result;
	private String algo;
	
	//Initialise algorithms
	private Levenshtein ls = new Levenshtein();
	private HammingDistance hd = new HammingDistance();
	private DamerauLevenshtein dl = new DamerauLevenshtein();
	private JaroWinkler jw = new JaroWinkler();
	
	public StringComparator(String str1, String str2, Resultator r, String algorithm){
		this.s = str1;
		this.t = str2;
		this.result = r;
		this.algo = algorithm;
		
		
	}

	public void run() {
		int distance;
		double distanceD;
		float distanceF;
		String distanceS;
		
		try{
			//Decide which string comparison algorithm to run.
			if(algo.equalsIgnoreCase("Levenshtein Distance")){
				
				distance = ls.distance(s, t);
				try {
					result.setResult("Levenshtein Distance is: "+distance);
					Thread.sleep(8000);
					result.setProcessed();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(algo.equalsIgnoreCase("Hamming Distance"))
			{
				distance = hd.distance(s, t);
				try {
					result.setResult("Hamming Distance is: "+distance);
					Thread.sleep(8000);
					result.setProcessed();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(algo.equalsIgnoreCase("Damerau-Levenshtein Distance"))
			{
				distance = dl.distance(s, t);
				try {
					result.setResult("Damerau-Levenshtein Distance: "+distance);
					Thread.sleep(8000);
					result.setProcessed();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(algo.equalsIgnoreCase("JaroWinkler Distance"))
			{
				distanceD = jw.getSimilarity(s, t);
				try {
					result.setResult("JaroWinkler Distance is: "+distanceD);
					Thread.sleep(8000);
					result.setProcessed();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
