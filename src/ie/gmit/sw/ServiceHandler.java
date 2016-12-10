package ie.gmit.sw;

import java.io.*;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServiceHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String remoteHost = null;
	private static long jobNumber = 0;
	Queueable queue;
	
	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER"); //Reads the value from the <context-param> in web.xml
		queue = new Queueable();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		boolean jobComplete = false;
		String distance = "";
		
		//Initialise some request variables with the submitted form info. These are local to this method and thread safe...
		String algo = req.getParameter("cmbAlgorithm");
		String s = req.getParameter("txtS");
		String t = req.getParameter("txtT");
		String taskNumber = req.getParameter("frmTaskNumber");


		out.print("<html><head><title>Distributed Systems Assignment</title>");		
		out.print("</head>");		
		out.print("<body>");
		
		if (taskNumber == null){
			jobNumber++;
			taskNumber = new String("T" + jobNumber);
			
			//Create a Job object from the request variables and the jobNumber
			Job job = new Job(s, t, algo, taskNumber);
			
			//Add the job to the queue
			queue.add(job);
			
		}else{
			
			//Check out-queue in Queueable if the job is finished
			jobComplete=queue.isComplete(taskNumber);
			
			if(jobComplete){
				distance=queue.getResult(taskNumber);
			}//end if
			
		}
		
		//If the task is complete there is no need to send the form again, just output a thank you message
		if(jobComplete){
			out.print("<font color=\"#993333\"><b>");
			out.print("<br><br><center>THANK YOU FOR USING THE SERVICE<center>");
			out.print("<br>Distance was calculated as: " + distance);
		}
		else//if task is not complete poll again
		{
			out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
			out.print("<div id=\"r\"></div>");
		
			out.print("<font color=\"#993333\"><b>");
			out.print("RMI Server is located at " + remoteHost);
			out.print("<br>Algorithm: " + algo);		
			out.print("<br>String <i>s</i> : " + s);
			out.print("<br>String <i>t</i> : " + t);
		
			//Form sends every 10 seconds to simulate a client polling. Keeps going until task is completed.
			out.print("<form name=\"frmRequestDetails\">");
			out.print("<input name=\"cmbAlgorithm\" type=\"hidden\" value=\"" + algo + "\">");
			out.print("<input name=\"txtS\" type=\"hidden\" value=\"" + s + "\">");
			out.print("<input name=\"txtT\" type=\"hidden\" value=\"" + t + "\">");
			out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
			out.print("</form>");								
			out.print("</body>");	
			out.print("</html>");	
		
			out.print("<script>");
			//Here is where we submit the form
			out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
			out.print("</script>");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}