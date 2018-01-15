
/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: September 3, 2017
 * Homework 2
 * Developed under windows 10 using eclipse
 * 
 * IOIntensive class: prints all five threads out. Each thread iterates from 0 -100.
 * Also, is capable of suspending, resuming, and waiting for each thread to reach 
 * 100. 
 */

public class IOIntensive implements Runnable 
{
	// variables used
	
	private Thread startThread;			// used to start each thread
	private String threadName = "";		// threadName declared as private, and is data type String
	private boolean suspended = false;	// suspended declared as private, and is type boolean, and assigned as false
	Time time = Time.start();			// calls the Time class. Used to keep track of the time each thread takes

	/**
	 * Computationally method: this is the constructor method, and is used to store the name of the
	 * thread1, thread2, thread3, and thread4.
	 * @param threadName
	 */
	
	public IOIntensive(String threadName) 
	{
		this.threadName = threadName;	// reference to threadName
	}
	
	/**
	 * run method: used to iterate all threads from 0 to 100. All threads
	 * must reach 100. Also, implements synchronized, which allows threads
	 * to suspend, wait, and resume.
	 */
	
	public void run() 
	{
		try 	// exception handling
		{
			for(int i = 0; i <= 100; i++) 		// for i = 0, and i <= to 100, then increment by 1
			{
				System.out.println(threadName + i);	// prints each thread and its current value in the iteration cycle of 0 -100
				Thread.sleep(100);					// causes the threads to sleep
				
				synchronized(this)		// ensures on current thread is suspended at once
				{
					while(suspended)	// while a thread is suspended
					{
						wait();		// current thread waits until another thread invoked the notify method
					}
				}
			}
		} 
		catch(InterruptedException e) 	// used to catch any threads that get interrupted
		{
			System.out.println("Thread " + threadName + " interrupted.");	// prints out thread that was interrupted
		}
		System.out.println("Exiting " + threadName + "after running for "  + time.toMinuteSeconds() + "\n");	// prints out the exiting time for each thread
		
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
	 * suspend method: created to put a thread in the suspended state, and can only
	 * start back up if the resume method is called.
	 */
	
	public void suspend()
	{
		suspended = true;	// if it is suspended
	}
	
	/**
	 * resume method: created to resume a thread that is in the suspended state. 
	 */
	
	synchronized void resume()
	{
		suspended = false;	// if suspend is false
		notify();			// wakes up thread
	}
}
