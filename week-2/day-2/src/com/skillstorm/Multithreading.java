package com.skillstorm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Multithreading {

	public static void main(String[] args) throws InterruptedException {
		
		// MULTITHREADING IN JAVA
		
		/*
		 * multithreading is allowing multiple threads to execute at the same time
		 * a thread is a line of processing, a sequence of operations
		 * a single thread is processed by a single processor, core, thread on a core, etc.
		 * 
		 * JavaScript is single-threaded, alas...
		 * 
		 * Java thread processing is limited by however many processors/cores your computer has
		 * You CAN create more than that many Thread objects, but you actually end up with a performance hit
		 * Threads have some overhead to set them up, have them integrate with other Threads, etc.
		 * 
		 * Main Purpose -- speed! parallel processing can be faster than serial processing
		 * Be careful about accessing joint resources when aiming for speed
		 * 
		 */
		
		// creating a Thread
		// this thread has not technically been born into existence until we run the .start() method
		// if you merely execute the run() method of the Runnable, it'll work, but the Thread will not start
		// it will just run in the main thread
		
		// instantiating an object that implements Runnable
		ThingToRun ttrA = new ThingToRun("Thread A");
		ThingToRun ttrB = new ThingToRun("Thread B");
		ThingToRun ttrC = new ThingToRun("Thread C");
		
		// feeding that object into a new Thread
		Thread myThreadA = new Thread(ttrA);
		Thread myThreadB = new Thread(ttrB);
		Thread myThreadC = new Thread(ttrC);
		
		// this actually starts the Thread's processing
		myThreadA.start();
		myThreadB.start();
		myThreadC.start();
		
		// join() waits until a Thread is finished before moving on to the next line of sequential code
		myThreadA.join();
		myThreadB.join();
		myThreadC.join();
		
		// you can also ask a Thread to sleep for a while!
		// the parameter is the number of milliseconds to nap for
//		myThreadA.sleep(1000);
		
		// we want this line to print ONLY AFTER all three Threads are done, so we need the joins
//		System.out.println("Finished all three Threads!");
		
		// other ways to feed functionality to a Thread
		// we need some sort of object, anonymous or otherwise, that implements the .run() method of Runnable
		
		// creating the anonymous class inline
		Thread longForm = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Some long-form running stuff...");
			}
			
		});
		
//		longForm.start();
		
		// providing implementation in shorter form
		Runnable shortFormRunnable = () -> System.out.println("Some short-form running stuff...");
		
		Thread shortForm = new Thread(shortFormRunnable);
		
//		shortForm.start();
		
		// using our BornToRun class and enforcing uninterrupted processing
		Thread btr1 = new Thread(new BornToRun("Born One"));
		Thread btr2 = new Thread(new BornToRun("Born Two"));
		Thread btr3 = new Thread(new BornToRun("Born Three"));
		
		btr1.start();
		btr2.start();
		btr3.start();
		
		

	}

}

class ThingToRun implements Runnable {
	
	static int[] jenny = { 8, 6, 7, 5, 3, 0, 9 };
	
	String name;
	
	public ThingToRun(String name) {
		this.name = name;
	}

	@Override
	public void run() {
//		for (int i : jenny)
//			System.out.println(this.name + ": " + i);
	}
	
}

// with this class, we'll include some thread-blocking mechanisms
// this way, we can ensure that actions that are supposed to happen together actually do
class BornToRun implements Runnable {
	
	// this static Lock is a class we can use to prevent access by other threads
	// once locked, other threads cannot move past the .lock() command until it is unlocked by the original locking thread
	static Lock lock = new ReentrantLock();
	
	// we can use this local object as a "conch" to prevent access to a synchronized block
	// it can be any type of object you like!
	static Object localMutex = new Object();
	
	static String[] sections = {
		"Verse 1",
		"Chorus 1",
		"Verse 2",
		"Chorus 2",
		"Bridge",
		"Epic Sax Solo",
		"The highway's jammed with broken heroes, etc.",
		"Whooooaaaa!",
		"Fadeout"
	};
	
	String name;
	
	public BornToRun(String name) {
		this.name = name;
	}

	// this version uses a Lock to prevent concurrent action
//	@Override
//	public void run() {
//		
//		// whichever thread makes it here first will lock the lock and prevent other threads from getting to this code
//		lock.lock();
//		
//		for (String section : sections)
//			System.out.println(name + " — " + section);
//		
//		// if you don't unlock the lock, the other threads will never start this method
//		lock.unlock();
//	}
	
	// this version uses a mutex to prevent concurrent action
//	@Override
//	public void run() {
//		
//		// using our mutex to lock this section out
//		synchronized (Mutex.getMutex()) {
//		
//			for (String section : sections)
//				System.out.println(name + " — " + section);
//		
//		}
//		
//	}
	
	// this method uses an external synchronized method
	// the external method must be static
	@Override
	public void run() {
		
		trampsLikeUs(name);
	
	}
	
	// a synchronized method can only be run by one thread at a time
	// since it's static, it doesn't have access to instance properties, so we have to take that in from the run() method
	public static synchronized void trampsLikeUs(String name) {
		for (String section : sections)
			System.out.println(name + " — " + section);
	}
	
}

// the singleton pattern is when you only want there ever to be ONE instance of a certain object
// it prevents there from EVER being more than one
// this involves a private constructor
class Mutex {
	
	// a place to hold our one and only mutex
	static Mutex mutex;
	
	// the constructor must be private, or we could create as many as we want
	private Mutex() {}
	
	// this method gets the mutex if it exists or creates a new one if it doesn't, then returns it
	// it has to be static, because, since the constructor is private, we can't create an instance to run it on
	// this method must also be synchronized to prevent two threads from getting the mutex before exiting this method
	static synchronized Mutex getMutex() {
		if (mutex == null)
			return mutex = new Mutex(); 
		return mutex;
	}
	
}



