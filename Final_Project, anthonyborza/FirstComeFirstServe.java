
/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: 10/12/17
 * Final Project
 * Developed under windows 10 using eclipse
 * 
 * FirstComeFirstServce Class: implements the FCFS schedule and instantiates 5 objects of each
 * class and runs each object.This class has one method, and that is to calculate the thread times
 * for both IOIntensive and Computationally threads. This method is used to calculate the wait times for
 * each thread, average wait time for all threads, and the total runtime for all threads. The FCFS algorithm 
 * is to show that job order does not matter.
 */

public class FirstComeFirstServe
{
	 /**
	 * FCFSAlgorithm: this method is used to calculate the wait times for each thread.
	 * It is used to calculate each threads time. It calculates the average wait times for
	 * all of threads. It calculates the total time in nanoseconds for each thread. Lastly, 
	 * it calculates the total run time for all IOIntensive threads, and Computationally threads.
	 * @param thread
	 * @return time
	 * @throws InterruptedException
	 */
	 
	 public static long[] FCFSAlgorithm(Time threads[]) 
	 {
		 long startTime[] = new long[10];				// startTime is declared as a data type long, and is an array of the 10
		 long IOTimes = 0;								// IOTimes is declared as data type long, and assigned 0
		 long compTimes = 0;							// compTimes is declared as data type long, and assigned 0
		 long overallRunTime = 0;						// overallRunTime is declared as data type long, and assigned 0
		 
    	 try	// exception handling
    	 { 
	         for(int i = 0; i < threads.length; i++)	// for i is 0, and less then the length of thread, increment
	         {	        	 
	             startTime[i] = System.nanoTime();		// returns the current value of each thread in nanoseconds
	             threads[i].start();					// starts the thread
	             threads[i].join();						// waits for the thread to die
	         }
    	 }
    	 catch(InterruptedException e)	// catches exception
    	 {
    		 System.out.println(e);		// prints exception message
    	 }
         
    	 // prints the performance measurements for the FCFS algorithm
    	 
	     System.out.println();
         System.out.println("--------------------------------------------------------------------------------------------------------------------------");
         System.out.println("First Come First Serve Algorithm (FCFS)");
         System.out.println();
   
         for(int i = 0; i < threads.length; i++)		// for i is 0, and less then the length of thread, increment
         {
        	 if(threads[i] instanceof IOIntensive && threads[i] != null)	// basically checking to see if the current thread is an IOIntensive one, and is not null
        	 {	
        		 IOTimes += threads[i].getStartTime() - startTime[i];		// gets the current wait times for those threads
        	 }
        	 else	// else
        	 {
        		 compTimes += threads[i].getStartTime() - startTime[i]; 	// gets the current wait times for the computationally threads
        	 }
        	 System.out.println(threads[i].getName());
        	 System.out.println("Wait time for: " + (threads[i].getStartTime() - startTime[i]) );	// prints the wait times for threads
        	 System.out.println("Turn Around Time for: " + threads[i].getTime());					// prints turn around time for threads
        	 System.out.println();
         }
         
         for(int i = 0; i < threads.length; i++)			// for i is 0, and less then the length of thread, increment
         {
        	 overallRunTime += threads[i].getTime();		// gets the total run time for all IOIntensive threads
         }
         
	     System.out.println();
	     System.out.println("Average wait times for IOIntensive Threads: " + IOTimes / 5);			// returns average wait times for all IOIntensive threads         
	     System.out.println("Average wait times for Computationally Threads: " + compTimes / 5);	// returns average wait times for all Computationally threads     
         System.out.println("Overall run time: " + overallRunTime);									// prints the total run times
         System.out.println("----------------------------------------------------------------------------------------------------------------------------");
         
         return startTime;	// return startTime
	 }	 
}
