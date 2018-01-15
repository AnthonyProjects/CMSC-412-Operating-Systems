
/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: September 10, 2017
 * Homework 3
 * Developed under windows 10 using eclipse
 * 
 * Computationally class extends Time: prints all five threads out. Each thread iterates from 0 - 100
 * and then performs the sum of all numbers 0 to 100.
 */

public class Computationally extends Time 
{
	// variables used
	
	public String threadName = "";		// threadName declared as private, and is data type String
	private int sum;					// sum declared as private, and is data type integer

	/**
	 * run method: used to iterate through all threads from 0 to 100. All threads
	 * must reach 100, and then calculates the sum of all numbers 0 to 100.
	 */
	
	@Override
	public void run() 
	{
		startTime = System.nanoTime();	// start time is in nanoTime
		System.out.println("Starting " + this.getName());	// displays when thread is starting
		
		for(int i = 0; i <= 100; i++) 	// for i = 0, and i <= to 100, then increment by 1
		{
			sum = sum + i;			// adds 1 each time
			System.out.println(this.getName() + ":  "  + i);	// prints name of thread, and value
		}
		System.out.println(this.getName() + ":  The sum from the numbers 0 through 100 is " + sum);	// prints the total sum of numbers 1 to 100
		time = System.nanoTime() - startTime;	// 	nanoTime minus startTime
		System.out.println("Finished " + this.getName() + " Time Taken: " + time);	// displays finished after thread is done
	}
	
	/**
	 * CalculateIOTimes: this method is used to calculate the wait times for each thread.
	 * It is used to calculate each threads time. It calculates the average wait times for
	 * all of threads. It calculates the total time in nanoseconds for each thread.Lastly, 
	 * it calculates the total run time for all Computationally threads.
	 * @param thread
	 * @return time
	 * @throws InterruptedException
	 */
	
    public static long[] calculateComputationallyTimes(Time thread[]) 
    {
    	 long time[] = new long[thread.length];		// time is declared as a data type long, and is an array of the thread length
         long times = 0;							// times is declared as data type long, and assigned 0
        
         // starting, keeping track of time for threads, setting priority of threads, and join the threads
         
         for(int i = 0; i < thread.length; i++)		// for i is 0, and less then the length of thread, increment
         {
        	   time[i] = System.nanoTime();		// returns the current value of each thread in nanoseconds
               thread[i].start();				// starts the thread
               try 
               {
            	   thread[i].join();
               }
               catch (InterruptedException e)
               {
            	   e.printStackTrace();
			   }				
         }
         
         // calculate waiting time for computationally threads 1 to 5
         
         System.out.println("----------------------------------------------------------------------------------------------------------------------------");
         System.out.println("Wait times for Computationally Threads in nanoseconds: ");
         System.out.println();
         
         for(int i = 0; i < thread.length; i++)		// for i is 0, and less then the length of thread, increment
         {
        	 times += thread[i].getStartTime() - time[i];
         }

	     // average wait times for computationally threads 
	     
         for(int i = 0; i < thread.length; i++)		// for i is 0, and less then the length of thread, increment
         {
             System.out.println("Total wait time for " + thread[i].getName() + " is : " + (thread[i].getStartTime() - time[i]) + "(nano) ");
         }
         System.out.println();
         System.out.println("The average wait times for Computationally Threads in nanonseconds: " + times / 5 + "(nano) ");
 
         // total run times for computationally threads
     	 
         for( int i = 0; i < thread.length; i++)	// for i is 0, and less then the length of thread, increment
         {
        	 times += thread[i].getTime();
         }
         System.out.println();
         System.out.println("Total run times for Computationally Threads in nanoseconds: " + times + "(nano) ");
         System.out.println("----------------------------------------------------------------------------------------------------------------------------");
         return time;	// return time
    }
    
    /**
     * createThreads method: creates 5 threads for the computationally class
     * @param number
     * @param IOThread
     * @return thread
     */
    
    public static Time[] createThreads(int number)
    {
    	Time thread[];	// calls the time class and creates a thread array
    	
		thread = new Computationally[number];	// holds number as place value in the array
		
		for(int i = 0; i < number; i++)			// for i is 0, and less then number, increment
		{
			thread[i] = new Computationally();
			thread[i].setName("Computationally Thread " + (i + 1));
		}
		return thread;	// return thread
    }

    /**
     * getTime method: gets the time for the computationally threads
     */
    
	public long getTime()
	{
		return time;	// return time
	}

	/**
	 * getStartTime method: gets the start time for the computationally threads
	 */
	
	@Override
	public long getStartTime()
	{
		return startTime;	// return startTime
	}
}
