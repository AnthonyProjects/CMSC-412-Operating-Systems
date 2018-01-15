

/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: September 3, 2017
 * Homework 2
 * Developed under windows 10 using eclipse
 * 
 * Computationally class: this class has 4 inner classes that perform 4 different sums.
 * The sums are 0 to 10, 0 to 25, and 0 to 50. The main class, or outer class, which is 
 * the Computationally class, performs the sum of all numbers from 0 to 100. Before it 
 * can calculate the sums, all five threads must reach 100.
 */

public class Computationally implements Runnable 
{
	private Thread startThread;			// used to start each thread
	public String threadName = "";		// threadName declared as private, and is data type String
	private int sum;					// sum declared as private, and is data type integer
	Time time = Time.start();			// calls the Time class. Used to keep track of the time each thread takes
	
	/**
	 * Computationally method: this is the constructor method, and is used to store the name of the
	 * thread5.
	 * @param threadName
	 */
	
	public Computationally(String threadName) 
	{
		this.threadName = threadName;	// reference to threadName
	}
	
	/**
	 * run method: used to tell the system how the thread will run. Implements a for loop
	 * that iterates from 0-100, and calculates the sum of the numbers 0-100. It does not
	 * calculate the sum, until all of the IOIntesive threads have finished. 
	 */
	
	@Override
	public void run() 
	{
		try // exception handling
		{
			for(int i = 0; i <= 100; i++) 	// for i = 0, and i <= to 100, then increment by 1
			{
				sum = sum + i;			// adds 1 each time
				Thread.sleep(130);		// causes the thread to sleep 
			}		
		}
		catch(InterruptedException e) 	// used to catch any threads that get interrupted
		{
			System.out.println("Thread " + threadName + " interrupted.");	// prints out thread that was interrupted
		}
		System.out.println("The sum from the numbers 0 through 100 is " + sum);	// prints the total sum of numbers 1 to 100
		System.out.println("Exiting " + threadName + "after running for "  + time.toMinuteSeconds() + "\n");
		System.out.println();
		System.out.println("Time after calculating the sums: " + time.toMinuteSeconds());	// prints total time to calculate sums
	}

	/**
	 * start method: used to start the threads
	 */
	
	public void start() 
	{
		System.out.println("Starting " + threadName +"\n");	// prints all threads that are starting
		
		if(startThread == null)		// if startThread is equal to null
		{
			startThread = new Thread(this, threadName);
			startThread.start();	// starts all threads
		}
	}
	
	/**
	 * inner class Sum75: calculates the sum of all numbers 0 though 50
	 */
	
	class Sum75 extends Thread 
	{
		// run method
		
		public void run() 
		{
				try 
				{
					for(int i = 0; i <= 75; i++) 	// for i = 0, and i <= to 75, then increment by 1
					{
						sum = sum + i;			// adds 1 each time
						Thread.sleep(170);		// thread sleeps
					} 
				}
				catch(InterruptedException e) 	// used to catch any threads that get interrupted
				{
					System.out.println("Thread " + threadName + " interrupted.");	// prints out thread that was interrupted
				}
				System.out.println("The sum from the numbers 0 through 75 is " + sum);	// prints sum of numbers 0 - 75
				
				System.out.println("Exiting " + Computationally.this.threadName + "after running for "  + time.toMinuteSeconds() + "\n");	// exits thread and shows time
			}
	}
	
	/**
	 * inner class Sum50: calculates the sum of all numbers 0 though 50
	 */
	
	class Sum50 extends Thread
	{
		// run method
		
		public void run() 
		{
				try 
				{
					for(int i = 0; i <= 50; i++) 	// for i = 0, and i <= to 50, then increment by 1
					{
						sum = sum + i;			// adds 1 each time
						Thread.sleep(235);		// thread sleeps
					} 
				}
				catch(InterruptedException e) 	// used to catch any threads that get interrupted
				{
					System.out.println("Thread " + threadName + " interrupted.");	// prints out thread that was interrupted
				}
				System.out.println("The sum from the numbers 0 through 50 is " + sum);	// prints sum of numbers 0 - 50
				System.out.println("Exiting " + Computationally.this.threadName + "after running for "  + time.toMinuteSeconds() + "\n");	// exits thread and shows time
			}
	}
	
	/**
	 * inner class Sum25: calculates the sum of all numbers 0 though 25
	 */
	
	class Sum25 extends Thread
	{
		// run method
		
		public void run() 
		{
				try 
				{
					for(int i = 0; i <= 25; i++) 	// for i = 0, and i <= to 25, then increment by 1
					{
						sum = sum + i;			// adds 1 each time
						Thread.sleep(450);		// thread sleeps
					} 
				}
				catch(InterruptedException e) 	// used to catch any threads that get interrupted
				{
					System.out.println("Thread " + threadName + " interrupted.");	// prints out thread that was interrupted
				}
				System.out.println("The sum from the numbers 0 through 25 is " + sum);	// prints sum of numbers 0 - 25
				System.out.println("Exiting " + Computationally.this.threadName + "after running for "  + time.toMinuteSeconds() + "\n");	// exits thread and shows time
			}
	}
	
	/**
	 * inner class Sum10: calculates the sum of all numbers 0 though 10
	 */
	
	class Sum10 extends Thread
	{
		// run method
		
		public void run() 
		{
			try 
			{
				for(int i = 0; i <= 10; i++) 	// for i = 0, and i <= to 10, then increment by 1
				{
					sum = sum + i;			// adds 1 each time
					Thread.sleep(1050);		// thread sleeps
				} 
			}
			catch(InterruptedException e) 	// used to catch any threads that get interrupted
			{
				System.out.println("Thread " + threadName + " interrupted.");	// prints out thread that was interrupted
			}
				System.out.println("The sum from the numbers 0 through 10 is " + sum);	// prints sum of numbers 0 - 10
				System.out.println("Exiting " + Computationally.this.threadName + "after running for "  + time.toMinuteSeconds() + "\n");	// exits thread and shows time
			}
			
		}
}
