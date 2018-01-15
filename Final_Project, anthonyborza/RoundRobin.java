

/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: 10/12/17
 * Final Project
 * Developed under windows 10 using eclipse
 * 
 * RoundRobin Class: This is a preemption scheduling algorithm. This class implements the
 * suspend and resume methods that are used to determine how long a thread should run
 * based on its time slice. To implement this algorithm, i looked at the two classes provided
 * by the instructor: threadproj.java, and ThreadClient.java, to help assist me during the 
 * development of the Round Robin algorithm.
 *
 */

public class RoundRobin extends Thread
{
	  // variables used throughout the program
	
	  private volatile static boolean suspend = true;			// suspend declared as a boolean, and is static, and assigned false
	  private volatile static boolean resume = true;			// resume declared as a boolean, and is static, and assigned false
	  private static int timeSlice;								// timeSlice declared as an integer, and is static
	  private static final int DEFAULT_TIME_SLICE = 1000;		// DEFAULT_TIME_SLICE is declared as a final integer, and is static, and assigned 1000, which is 1 second
	
	/**
	 * Round Robin method: this is the constructor method for the 
	 * Round Robin class.
	 */
	
	  public RoundRobin()
	  {
		  timeSlice = DEFAULT_TIME_SLICE;			
		  System.out.println("Round Robin Algorithm ");	
	  }

    /**
     * schedulerSleep method: used to put the current thread to sleep
     * using the assigned timeSlice declared above.
     */
   
     private static void schedulerSleep() 
     {
         try 	// exception handling
         {
             Thread.sleep(timeSlice);
         } 
         catch(InterruptedException e) 	// catches any exceptions
         {
        	 System.out.println("An Error has occured " + e);	// prints the exception 
         };
     }
	  
	  /**
	   * RoundRobinAlgorithm method: this method implements the suspend and resume methods
	   * to determine when a thread should run and not run based on its assigned time slice.
	   * This method also calls the Time class, which is used for calculating the performance
	   * metrics to include: wait times, and turn around times for each thread, and the average 
	   * wait time, average turn around, adn overall runtime for all threads.
	   * @param thread
	   */
	  
     public static void RoundRobinAlgorithm(Time thread[])
	 {
	     // variables used throughout this method
    	 
    	 long turnAround = 0;						// turnAround declared as data type long, and assigned 0
	     long waitTime = 0;							// waitTime declared as data type long, and assigned 0
	     long overallRuntime = 0;					// overallRunTime declared as data type long, and assigned 0
	     long startTime[] = new long[10];			// startTime is declared as a data type long, and is an array of the 10
	     
		 try	// exception handling
		 {
				for(int i = 0; i < thread.length; i++)		// for int is 0, and less than the length of the total number of threads, increment i
				{
					startTime[i] = System.nanoTime();		// starts time for the threads
				    thread[i].start();						// starts threads
				    thread[i].suspend();					// suspends threads
				}
				
				int current = 0;  							// current is declared as data type integer, and assigned 0

				while(suspend) 								// while suspended
				{		
					if((threadCount(thread) != 0)) 			// if the threadCount method does not equal 0
					{
						try									// exception handling
						{	
							thread[current].resume();		// resume the current thread
							System.out.println("Context Switching..." + "to " + thread[current].getName());
							
							schedulerSleep();				// calls the schedulerSleep method, and implements time slice
						}
						catch(Exception e)					// catch exception
						{
							synchronized(thread[current])	// synchronized thread
							{
								thread[current].notify();	// notifies thread if there is a exception
							}
						};
						while(resume)						// while resume, suspend and wait for one quantum
						{
							// if the time of the current thread minus - Nanotime is not equal to time slice, and current thread is alive
							
							if(((System.nanoTime() - startTime[current] != timeSlice) && (thread[current].isAlive()))) {

								//thread[current].suspend();
							}
							else {break;}					// else break
						}				
						try									// exception handling
						{
							thread[current].suspend();		// suspend the thread
						}						
						catch(Exception e)					// catch exception
						{
							synchronized(thread[current])	// synchronized thread
							{
								thread[current].notify();	// notifies thread if there is a exception
							}							
						};

						current = ((current + 1) % thread.length);	// gives the next timeSlice to the process (thread)
					}
					else { break;}							// else break
				}
		 }
		 catch(Exception e)									// catch exception
		 {
			 Thread.currentThread().interrupt();			// displays a message if there is an interruption with the current thread
		 }

		 // prints the performance measurements for the RR algorithm
		 
		 System.out.println("-----------------------------------------------------------------");
		 
		 System.out.println("\nRound Robin Algorithm (RR)");	// prints statement for Round Robin Algorithm (RR)
		 System.out.println();

		 
         for(int i = 0; i < thread.length; i++)		// for i is 0, and less then the length of thread, increment
         {
	       	waitTime += (thread[i].getStartTime() - startTime[i]);		// formula to calculate wait time
	       	turnAround += (thread[i].getTime());						// formula to calculate turn around time
	       	
	       	System.out.println(thread[i].getName());											// prints name of each thread
	        System.out.println("Wait Time : " + (thread[i].getStartTime() - startTime[i]));		// prints wait time for each thread
	        System.out.println("Turn Around Time: " + thread[i].getTime());						// prints turn around time for each thread
	        System.out.println();	
         }
       
         for(int i = 0; i < thread.length; i++)		// for i is 0, and less then the length of thread, increment
         {
       		overallRuntime += thread[i].getTime();	// gets the total run time for all  threads
         }
       
         System.out.println("Average waiting time is : "+ waitTime / 10);				// calculates average wait time of all threads
         System.out.println("Average turn around time is : "+ turnAround / 10);		// calculates average turn around time of all threads
         System.out.println("Overall Runtime is: " + overallRuntime);					// calculates overall run time
       
         System.out.println();
         System.out.println("--------------------------------------------------------------------");
   }
	  
	  /**
	   * threadCount method: returns the current number of active threads
	   * @param thread
	   * @return count
	   * @throws InterruptedException 
	   */
	  
	   public static int threadCount(Time thread[]) throws InterruptedException
	   {
	        int counter = 0;						// counter declared as an integer and given the value 0
	        
	        for(int i = 0; i < thread.length; i++)	// for i is 0, and less then the length of thread, increment
	        {
	            if(thread[i].isAlive())				// test whether the thread is currently running or has been blocked
	            { 
	            	counter++;						// increment counter
//	            	thread[i].suspend();
	            }
//	            if(thread[i].isAlive())				// test whether the thread is currently running or has been blocked
//	            { 
//	            	counter++;						// increment number
//	            	thread[i].resume();
//	            	
//	            }
	        }
	        return counter;		// return counter
	   }     
}
