 
/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: 10/12/17
 * Final Project
 * Developed under windows 10 using eclipse
 * 
 * Time class extends Thread: used as an abstract class. It holds the variables
 * time, startTime, and method getTime(), and getStartTime(), to calculate the times 
 * for the threads.
 */

public abstract class Time extends Thread
{
	 protected  long time;					// time can be accessed by all classes in the same package
     protected  long startTime;				// startTime can be accessed by all classes in the same package

     public abstract long getTime();		// getTime method can be accessed by all classes in the same package
     public abstract long getStartTime();	// getStartTime method can be accessed by all classes in the same package

}
