
/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: September 3, 2017
 * Homework 2
 * Developed under windows 10 using eclipse
 * 
 * Controller class: used to run the threads, and perform operations on them such as,
 * start, suspend, resume, and sleep.
 */

public class Controller
{
	/**
	 * Main method: used to execute threads, and perform operations on them
	 * @param args
	 */
	
	public static void main(String args[])
	{
		
		Time time = Time.start();		// calls the Timer class, and the start method in that class
		
		// IOIntensive threads - used to iterate through the numbers 0 to 100
		
		IOIntensive thread1 = new IOIntensive("Thread 1:  "); 	// creates thread1 for IOIntensive class
		thread1.start();										// starts thread1 for IOIntensive class
		
		IOIntensive thread2 = new IOIntensive("Thread 2:  ");	// creates thread2 for IOIntensive class
		thread2.start();										// starts thread2 for IOIntensive class
		
		IOIntensive thread3 = new IOIntensive("Thread 3:  ");	// creates thread3 for IOIntensive class
		thread3.start();										// starts thread3 for IOIntensive class
		
		IOIntensive thread4 = new IOIntensive("Thread 4:  ");	// creates thread4 for IOIntensive class
		thread4.start();										// starts thread4 for IOIntensive class
		
		IOIntensive thread5 = new IOIntensive("Thread 5:  ");	// creates thread5 for IOIntensive class
		thread5.start();										// starts thread4 for IOIntensive class
		
		// Computationally threads - used to display 5 different sums 
		
		Computationally thread6 = new Computationally("Thread 6: ");	// creates  thread 5 for the  Computationally class
		thread6.start();												// starts thread6											
		
		Computationally.Sum75 thread7 = new Computationally("Thread 7: ").new Sum75(); 	// creates thread 7 for sum75 class in computationally class
		thread7.start();																// starts thread7
		
		Computationally.Sum50 thread8 = new Computationally("Thread 8: ").new Sum50();	// creates thread 8 for sum50 class in computationally class
		thread8.start();																// starts thread8
		
		Computationally.Sum25 thread9 = new Computationally("Thread 9: ").new Sum25();	// creates thread 9 for sum25 class in computationally class
		thread9.start();																// starts thread9
		
		Computationally.Sum10 thread10 = new Computationally("Thread 10: ").new Sum10();	// creates thread 10 for sum10 class in computationally class
		thread10.start();																	// starts thread10
		
		 try	// exception handling for threads
		 {
			 // performs suspend, resume, and sleep methods on thread 1
			 Thread.sleep(1000);														// causes thread to sleep
			 thread1.suspend();															// suspends thread1
			 System.out.println("Suspending Thread 1 at "  + time.toMinuteSeconds());	// prints time thread1 was suspended
			 Thread.sleep(1000);														// causes thread to sleep
			 System.out.println("Resuming thread 1 at "  + time.toMinuteSeconds());		// prints time thread1 was resumed
			 System.out.println();
			 thread1.resume();															// resumes thread1 
			 
			 // performs suspend, resume, and sleep methods on thread 2
			 thread2.suspend();															// suspends thread2
			 System.out.println("Suspending Thread 2  at "  + time.toMinuteSeconds());	// prints time thread2 was suspended
			 System.out.println();	
			 Thread.sleep(1000);														// causes thread2 to sleep
			 System.out.println("Resuming thread 2 at "  + time.toMinuteSeconds());		// prints time thread2 was resumed
			 System.out.println();
			 thread2.resume();															// resumes thread2
			 
			 // performs suspend, resume, and sleep methods on thread 3
			 thread3.suspend();															// suspends thread3
			 System.out.println("Suspending Thread 3 at "  + time.toMinuteSeconds());	// prints time thread3 was suspended
			 System.out.println();
			 Thread.sleep(1000);														// caused thread3 to sleep
			 System.out.println("Resuming thread 3 "  + time.toMinuteSeconds());		// prints time thread3 was resumed
			 System.out.println();
			 thread3.resume();															// resumes thread3
			 
			 // performs suspend, resume, and sleep methods on thread 4
			 thread4.suspend();															// suspends thread4
			 System.out.println("Suspending Thread 4 at "  + time.toMinuteSeconds());	// prints time thread4 was suspended
			 System.out.println();
			 Thread.sleep(1000);														// causes thread4 to sleep
			 System.out.println("Resuming thread 4 at "  + time.toMinuteSeconds());		// prints time thread4 was resumed
			 System.out.println();
			 thread4.resume();															// resumes thread4
			 
			 // performs suspend, resume, and sleep methods on thread 4
			 thread5.suspend();															// suspends thread4
			 System.out.println("Suspending Thread 4 at "  + time.toMinuteSeconds());	// prints time thread4 was suspended
			 System.out.println();
			 Thread.sleep(1000);														// causes thread4 to sleep
			 System.out.println("Resuming thread 4 at "  + time.toMinuteSeconds());		// prints time thread4 was resumed
			 System.out.println();
			 thread5.resume();															// resumes thread4
	
		 } 
		 catch(InterruptedException e) // catches any threads that cause problems
		 {	
	         System.out.println("Main thread Interrupted"); 	// prints a statement if main thread has been interrupted
		 }		 

	}
}
