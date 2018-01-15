/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: September 10, 2017
 * Homework 3
 * Developed under windows 10 using eclipse
 * 
 * Controller class: implements the FCFS schedule and instantiates 5 objects
 * of each class and runs each object.
 */

public class Controller
{
	 public static void main(String[] args) throws InterruptedException 
	 {
		  // there are 5 threads per class
		  int totalThreads = 5;
		  
		  
		  /** IOIntensive before Computationally **/
		  
		  // calculates times for IOIntensive
	      IOIntensive.calculateIOTimes(IOIntensive.createThreads(totalThreads));
	      System.out.println();
	      
	      // calculates time for Computationally
	      Computationally.calculateComputationallyTimes(Computationally.createThreads(totalThreads));
	      System.out.println();
	      
	      /** Computationally before IOIntensive **/
	      
//	      // calculates time for Computationally
//	      Computationally.calculateComputationallyTimes(Computationally.createThreads(totalThreads));
//	      System.out.println();
//	      
//		  // calculates times for IOIntensive
//	      IOIntensive.calculateIOTimes(IOIntensive.createThreads(totalThreads));
//	      System.out.println();
//	      
	   }
	    
}
