package com.skillstorm;

import java.io.IOException;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		// EXCEPTION HANDLING IN JAVA
		
		/*
		 * try/catch
		 * 
		 * pass the Exception along to the calling method
		 * 
		 * throw the Exception! (not handle it)
		 */
		
		// with try/catch, we try some code, and if it works, great!
		// but if it doesn't and it throws an exception, we can catch that exception and do whatever with it
		
		try {
			
			System.out.println("I'm trying, guys...");
			// this throws and Arithmetic Exception (runtime)
			int x = 1/0;
			// this throws an IOException, obviously
			throw new IOException();
			
		
		// you CAN do this to catch multiple exceptions in the same catch block
//		} catch(IOException | ArithmeticException e) {
//			
//			System.out.println("Caught it!");
//			e.printStackTrace();
//		}
			
		} catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Can't divide by zero, duh!");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Probably shouldn't have manually thrown this Exception.");
		}
		
		System.out.println("Moved on successfully!");
		
		
		// if Exceptions have inheritance relationships, you must catch them from most -> least specific
		// otherwise, they all get caught by the more general one
		try {
			throw new Exception();
		} catch(ArithmeticException e) {
			e.printStackTrace();
		} catch(RuntimeException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		// the finally block ALWAYS executes, whether an Exception is thrown and handled or not
		} finally {
			System.out.println("Finally block is running!");
		}
		
		// what combinations are allowed?
		
		/*
		 * try/catch (as many catches as you need)
		 * try/catch/finally (as many catches as you need)
		 * try/finally
		 * 
		 * MUST have a try with at least EITHER a catch OR finally
		 */
		System.out.println("\n\n");
		
		try {
			System.out.println(divide(1000, 0));
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		
		System.out.println("Properly handled again!");
		
	}
	
	// be sure to anticipate possible Exceptions beyond the checked ones
	// here, we're passing the handling up to the calling method and dealing with it there
	public static double divide(int a, int b) throws IOException {
		if (a == 1000)
			throw new IOException("Can't divide 1000 by anything!");
		return a / b;
	}

}
