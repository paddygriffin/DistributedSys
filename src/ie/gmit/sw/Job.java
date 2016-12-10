package ie.gmit.sw;

public class Job {
	
	private String taskNumber;
	private String algo;
	private String str1;
	private String str2;
	
	//Constructor
	public Job(String taskNumber, String algo, String str1, String str2) {
		this.algo = algo;
		this.str1 = str1;
		this.str2 = str2;
	}

	public String getTaskNumber() {
		return taskNumber;
	}
	
	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}
	
	public String getStr1() {
		return str1;
	}
	
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	
	public String getStr2() {
		return str2;
	}
	
	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}

}
