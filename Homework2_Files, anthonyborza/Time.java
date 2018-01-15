
/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: September 3, 2017
 * Homework 2
 * Developed under windows 10 using eclipse
 * 
 * Time class: this class is designed to provide execution times for each thread.
 * For example, when it started, when it was suspended, when it was resumed, and 
 * when it was completed. The output is in minutes and seconds. Ex: 0 min, 6 sec
 * Reference: https://docs.oracle.com/cd/E17802_01/j2se/j2se/1.5.0/jcp/beta1/apidiffs/java/util/concurrent/TimeUnit.html
 */

import java.util.concurrent.TimeUnit;

public class Time 
{

	private long start;		// start declared as private, and data type long
 
	/**
	 * Time method: calls the reset method
	 */
	
	private Time()
	{
		reset();	// calls reset method
	}
	
	/**
	 * Start method: used to start the time of the threads.
	 * @returns the Time method
	 */
	
    public static Time start()
    {
		return new Time();	// returns the Time method
	}

    /**
     * reset method: resets the time of the threads.
     * @return
     */
    
    public Time reset()
    {
    	start = System.nanoTime();		// current value of the running Java Virtual Machine's
    	return this;					// returns in nanoseconds
    }
    /**
     * time method
     * @return end time minus the start time of each thread
     */
    
    public long time()
    {
    	long end = System.nanoTime();	// current value of the running Java Virtual Machine's
    	return end - start;				// returns the end time in nanoseconds minus the start time in nanoseconds
    }
    
    /**
     * time method: represents time durations at a given unit of granularity and provides utility methods to convert across units
     * @param unit
     * @return the converted time duration of the unit
     */
    
    public long time(TimeUnit unit)
    {
    	return unit.convert(time(), TimeUnit.NANOSECONDS);	// converts the time duration of this unit
    }
    
    /**
     * toMintueSeconds method: used to convert to total minutes and second.
     * @return the total minutes and seconds in string format
     */
    
    public String toMinuteSeconds()
    {
        return String.format("%d min, %d sec", time(TimeUnit.MINUTES), time(TimeUnit.SECONDS) - time(TimeUnit.MINUTES));	// returns the minutes, and seconds of each thread in string format
    }
}
