import java.util.ArrayList;
import java.util.Collections;

/**
 * Anthony Borza
 * Professor Tarquinio, Michael 
 * Due Date: 10/12/17
 * Final Project
 * Developed under windows 10 using eclipse
 * 
 * Controller class: creates the threads for each algorithmL FCFS, SJF and RR.
 * It this calls the schedule algorithms class, and performs the algorithm
 */

public class Controller
{
	/**
	 * Main Method: executes program. Creates threads for all scheduling algorithms. 
	 * Each algorithm is provided an ArrayList that is used to display the threads in
	 * random order for both IOIntensive and Computationally. Within this method, each 
	 * scheduling algorithm class is called, and performs it operations. 
	 * @param args
	 * @throws InterruptedException
	 */
	
	 public static void main(String[] args) throws InterruptedException 
	 {
		  	int totalThreads = 10;												// total threads for both IOIntensive, and Computationally	
		  	Time[] threads = new Time[totalThreads];							// calls the Time class and stores totalThreads in it
		  	
		  	ArrayList<Integer> MixThreads = new ArrayList<Integer>();			// makes an ArrayList called MixThreads
		  	ArrayList<Integer> SJFRandomThreads = new ArrayList<Integer>();		// makes an ArrayList called SJFRandomThreads
		 
/************************************************FCFSAlgorithm********************************************************/	

			for(int i = 0; i < threads.length; i++)		// for i is 5, and less then 5, increment i
			{
				if(i < 5)	// if i is less than 5 display IOIntensive threads
				{
					threads[i] = new IOIntensive();								// calls the IOIntensive class 
					threads[i].setName("IO Intensive Thread : "+ (i + 1));		// making a new thread
				}
				else	// else display Computationally threads
				{
					threads[i] = new Computationally();							// calls the Computationally class 
					threads[i].setName("Computationally Thread : "+ (i + 1)); 	// making a new thread
				}
	    	}
		
			// calls the FirstComeFirstServe class, and performs the FCFSAlgorithm method

			FirstComeFirstServe.FCFSAlgorithm(threads);

/************************************************MixtureOfThreads********************************************************/	

			for(int i = 0; i < threads.length; i++)
 			{
				MixThreads.add(i);				// adds the threads to ArrayList 
 			}
 			
 			Collections.shuffle(MixThreads);		// shuffles the threads in random order
			
			
 			for(int i = 0; i < threads.length; i++)		// for i is 5, and less then 5, increment i
			{
				if(i < 5)	// if i is less than 5 display IOIntensive threads
				{
					threads[MixThreads.get(i)] = new IOIntensive();							// calls the IOIntensive class 
					threads[MixThreads.get(i)].setName("IO Intensive Thread : "+ (i + 1));	// making a new thread
				}
				else		// else display Computationally threads
				{
					threads[MixThreads.get(i)] = new Computationally();							// calls the Computationally class 
					threads[MixThreads.get(i)].setName("Computationally Thread : "+ (i + 1));	// making a new thread
				}
	    	}

 			// calls the MixtureOfThreads class, and performs the MixThreads method

 			MixtureOfThreads.MixThreads(threads);
 			
/*********************************************************************************************************************/				
			
			
/************************************************SJFAlgorithm*********************************************************/			
			// creates threads for SFJ algorithm, sorts threads in ascending order 
			// regardless of the order the threads are inserted in
			
			// for loop that adds the threads to an ArrayList
			
			for(int i = 0; i < threads.length; i++)
 			{
				SJFRandomThreads.add(i);				// adds the threads to ArrayList 
 			}
 			
 			Collections.shuffle(SJFRandomThreads);		// shuffles the threads in random order
			
			
 			for(int i = 0; i < threads.length; i++)		// for i is 5, and less then 5, increment i
			{
				if(i < 5)	// if i is less than 5 display IOIntensive threads
				{
					threads[SJFRandomThreads.get(i)] = new IOIntensive();							// calls the IOIntensive class 
					threads[SJFRandomThreads.get(i)].setName("IO Intensive Thread : "+ (i + 1));	// making a new thread
				}
				else		// else display Computationally threads
				{
					threads[SJFRandomThreads.get(i)] = new Computationally();							// calls the Computationally class 
					threads[SJFRandomThreads.get(i)].setName("Computationally Thread : "+ (i + 1));		// making a new thread
				}
	    	}
 			
 			// calls the ScheduleFirstJob class, and performs the SJFAlgorithm method
 			
			ScheduleFirstJob.SJFAlgorithm(threads);	
			
/********************************************************************************************************************/					
			
/************************************************RRAlgorithm*********************************************************/	
			
 			for(int i = 0; i < threads.length; i++)		// for i is 5, and less then 5, increment i
			{
 			
				if(i < 5)	// if i is less than 5 display IOIntensive threads
				{	
					threads[i] = new IOIntensive();								// calls the IOIntensive class 
					threads[i].setName("IO Intensive Thread : "+ (i + 1));		// making a new thread
				}
				else	// else display Computationally threads
				{
					threads[i] = new Computationally();							// calls the Computationally class 
					threads[i].setName("Computationally Thread : "+ (i + 1));	// making a new thread
				}
	    	}

			// calls the RoundRobin class, and performs the RoundRobinAlgorithm method
			
			RoundRobin.RoundRobinAlgorithm(threads);
			
/********************************************************************************************************************/	
	   }	 
}
