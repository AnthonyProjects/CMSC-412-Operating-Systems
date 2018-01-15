import java.util.concurrent.TimeUnit;

/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: 10/12/17
 * Final Project
 * Developed under windows 10 using eclipse
 * 
 * ScheduleFirstJob class: sorts threads in ascending order, from least to greatest based
 * on their burst times, wait times, and turn around times.
 * 
 */

public class ScheduleFirstJob 
{

 	 /**
     * SJFIOIntensive Method: this displays the burst time, wait time, and turn around time in order, from
     * shortest job to largest job. This algorithm implements the bubble sort algorithm to sort the threads. 
     * I used the following reference to help assist me with the implementation of this algorithm:
     * http://www.geeksforgeeks.org/program-shortest-job-first-scheduling-set-2srtf-make-changesdoneplease-review/
     * @param thread
     * @return time
     */
 	 
    public static long[] SJFAlgorithm(Time thread[])
    {
    	// variables to be used throughout this method
    	
    	long number;											// number declared as data type long
    	long overallRunTime = 0;								// overallRunTime is declared as data type long, and assigned 0
    	long averageWaitTime = 0;								// averageWaitTime is declared as data type long, and assigned 0
     	long averageTurnAroundTime = 0;							// averageTurnAroundTime is declared as data type long, and assigned 0
		long[] burstTime = new long[thread.length + 1];			// burstTime declared as an array, and takes the thread length plus 1
		long[] waitTime = new long[thread.length + 1];			// waitTime declared as an array, and takes the thread length plus 1
		long[] turnAroundTime = new long[thread.length + 1];	// TurnAroundTime declared as an array, and takes the thread length plus 1
		long[] time = new long[thread.length];					// time declared as an array, and takes the thread length
		
    	try 	// exception handling
    	{
			 for(int i = 0; i < thread.length; i++)		// for i is 0, and less then the length of thread, increment
	         {
	        	 burstTime[i] = System.nanoTime();		// returns the current value of each thread in nanoseconds
	             thread[i].start();						// starts the thread
	        	 thread[i].join();						// joins the threads
	         }
    	 }
         catch(InterruptedException e)		// catches exception
         {
    	    e.printStackTrace();			// prints exception 
	     }
        
         // sets initial wait time, and turn around time to 0
         
         for(int i = 0; i < thread.length; i ++)	// for int is 0, and less than the length of the total number of threads, increment i
         {
        	 waitTime[i] = 0;				// waitTime for first thread set to 0
        	 turnAroundTime[i] = 0;			// turnAroundTime for first thread set to 0
         }
         
         System.out.println();
         System.out.println("-----------------------------------------------------------------------------------------------------------------");
         System.out.println();

         // this is where the threads are sorted in ascending order
         
         for(int i = 0; i < thread.length; i++)					// for i is 0, and greater less than the thread length, increment i
         {
        	 for(int j = 0; j < thread.length - 1; j++)			// for j is 0, and greater less than the thread length - 1, increment f
        	 {
        		 if(burstTime[j] > burstTime[j + 1])			// if burstTime[j] is greater than burstTime[j + 1]
        		 {
        			 // swap number and burstTime[i]
        			 
        			 number = burstTime[j];
        			 burstTime[j] = burstTime[j + 1];
        			 burstTime[j + 1] = number;
        			 
        			 // swap number and waitTime[i]
        			 
        			 number = waitTime[j];
        			 waitTime[j] = waitTime[j + 1];
        			 waitTime[j + 1] = number;
        		 }
        	 }
         }
       
         for(int i = 0; i < thread.length; i ++)					// for i is 0, and greater less than the thread length, increment i
         {
    		  turnAroundTime[i] = burstTime[i] + waitTime[i];		// turn around time for each thread, is the burst time plus the wait time
    		  waitTime[i + 1] = turnAroundTime[i];					
         }
          turnAroundTime[thread.length] = waitTime[thread.length] + burstTime[thread.length];
          
          // Calculates average wait time
          
          for(int i = 0; i < thread.length; i++)					// for i is 0, and greater less than the thread length, increment i
          {
        	  turnAroundTime[i] = burstTime[i] + waitTime[i];
        	  averageWaitTime += waitTime[i];
          }
          averageWaitTime = averageWaitTime / thread.length;		// calculates average wait time
          
          // Calculates average turn around time
          
          for(int i = 0; i < thread.length; i++)					// for i is 0, and greater less than the thread length, increment i
          {
        	  turnAroundTime[i] = waitTime[i] + burstTime[i];						// calculates the turn around time, which is wait time plus burst time
        	  averageTurnAroundTime = averageTurnAroundTime + turnAroundTime[i];	// calculates average turn around time
          }
       
          // prints the performance measurements for the SJF algorithm
          
          System.out.println("Schedule Job First Algorithm (SJF)");
	      System.out.println();
          
	      for(int i = 0; i < thread.length; i++)				// for i is 0, and greater less than the thread length, increment i
	      {
	      	 System.out.println(thread[i].getName() + ": " );
	      	 System.out.println("Burst Time: " + TimeUnit.MILLISECONDS.convert(burstTime[i], TimeUnit.NANOSECONDS));
	      	 System.out.println("Wait Time: " + TimeUnit.MILLISECONDS.convert(waitTime[i], TimeUnit.NANOSECONDS));
	      	 System.out.println("Turn Around Time: " +  TimeUnit.MILLISECONDS.convert(turnAroundTime[i], TimeUnit.NANOSECONDS));
	      	 System.out.println();
	      }
	      
	      // calculates overall runtime
	      
	      for(int i = 0; i < thread.length; i++)		// for i is 0, and less then the length of thread, increment
	      {
	    	  overallRunTime += thread[i].getTime();	// gets the total run time for all IOIntensive threads
	      }
	      
	    // prints average wait time, and average turn around time
	      
       System.out.println();
       System.out.println("Average Wait Time: " + TimeUnit.MILLISECONDS.convert(averageWaitTime, TimeUnit.NANOSECONDS));
       System.out.println("Average Turn Around Time: " + TimeUnit.MILLISECONDS.convert(averageTurnAroundTime, TimeUnit.NANOSECONDS));
       System.out.println("Overall run time: " + overallRunTime);
       
       System.out.println();
       System.out.println("-----------------------------------------------------------------------------------------------------------------");
       
       return time;		// return time
    }
}
