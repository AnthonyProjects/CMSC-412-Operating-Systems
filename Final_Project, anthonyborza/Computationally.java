
/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: 10/12/17
 * Final Project
 * Developed under windows 10 using eclipse
 * 
 * Computationally class extends Time: prints all five threads out. Each thread iterates from 0 - 100
 * and then performs the sum of all numbers 0 to 100.
 */

public class Computationally extends Time implements Runnable
{

	private int sum;	// sum declared as private, and is data type integer
	
	/**
	 * run method: used to iterate through all threads from 0 to 100. All threads
	 * must reach 100, and then calculates the sum of all numbers 0 to 100.
	 */
	
	@Override
	public void run() 
	{
		startTime = System.nanoTime();							// start time is in nanoTime
		System.out.println("Starting " + this.getName());		// displays when thread is starting
		
		for(int i = 0; i <= 100; i++) 							// for i = 0, and i <= to 100, then increment by 1
		{
			sum = sum + i;										// adds 1 each time
			System.out.println(this.getName() + ":  "  + i);	// prints name of thread, and value
		}
		System.out.println(this.getName() + ":  The sum from the numbers 0 through 100 is " + sum);	// prints the total sum of numbers 1 to 100
		time = System.nanoTime() - startTime;					// 	nanoTime minus startTime
		System.out.println();
		
		synchronized(this) 
		{
			System.out.println("Finished " + this.getName());	// prints when current thread has finished
		}
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
