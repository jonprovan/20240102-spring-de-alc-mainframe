package com.skillstorm;

import java.util.ArrayList;

public class DataTypes {

	public static void main(String[] args) {
		
		// DATA TYPES IN JAVA
		
		/*
		 * PRIMITIVES
		 * non-objects
		 * stored in the stack
		 * 
		 * Numerical types
		 * 
		 * Whole Numbers
		 * byte = 8 bits
		 * short = 16 bits
		 * int = 32 bits
		 * long = 64 bits
		 * 
		 * Decimal Numbers
		 * float = 32 bits
		 * double = 64 bits
		 * 
		 * Alphanumeric
		 * char = a single character, uses single-quotes ('f'), can be incremented
		 * 
		 * True/False
		 * boolean = one bit, true or false
		 * 
		 * NON-PRIMITIVES
		 * stored in the heap
		 * objects
		 * 
		 * String -> we kinda think of it like a primitive, but it's not
		 * - any number of characters in double-quotes
		 * Any custom object we create
		 * Any Java object
		 * Any data structure
		 */
		
		// note that access modifiers don't apply inside of a method
		int myInt = 6;
		System.out.println(myInt);
		
		int myInt2;
		myInt2 = 10;
		System.out.println(myInt2);
		
		byte myByte = 55;
		System.out.println(myByte);
		
		// Java thinks of all whole numbers as int unless specified otherwise
		// this number is too big for int, so it complains unless we add the L at the end
		long myLong = 123123123123L;
		
		double myDouble = 123.123;
		System.out.println(myDouble);
		
		// decimals stored in whole number types lop off everything after the decimal point
		int myDoubleInt = (int) 123.123;
		System.out.println(myDoubleInt);
		
		// Java thinks of all decimals as doubles unless specified otherwise
		// this number needs to be indicated as a float with the f
		float myFloat = 123.123f;
		
		// careful with integer math!
		// you must tell Java the first number is a double/float before doing the math
		System.out.println((double)5 / 2);
		
		// incrementing a char
		char myChar = 'a';
		myChar++;
		System.out.println(myChar);
		
		boolean myBoolean = true;
		System.out.println(!myBoolean);
		
		System.out.println(Long.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		Long myLongObject = new Long(123123123);
		System.out.println(myLongObject);
		
		Methods.printHi();

	}

}
