package com.skillstorm;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		// FUNCTIONAL INTERFACES IN JAVA
		
		/*
		 * a Functional Interface is an interface with exactly ONE unimplemented abstract method
		 * the idea behind them is that you can anonymously instantiate an Object from the Interface
		 * by providing it with implementation inline
		 * 
		 * you cannot have more than one unimplemented method
		 * there is an annotation we can use to enforce this
		 */
		
		// instantiating an object from our Functional Interface
		Func1 f1 = () -> "Implemented!";
		
		System.out.println(f1.getString());
		
		Func1 f2 = () -> {
			int x = 11;
			int y = x * x;
			return "Return value is: " + y;
		};
		
		System.out.println(f2.getString());
		
		Integer[] nums = { 1, 3, 5, 4, 2 };
		
		// same functionality, different syntactical approach
		// we provide the implementation for the compare method inline
		// the class implementing it is anonymous, i.e., it has no name
		Arrays.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
			
		});
		
		for (Integer i : nums)
			System.out.println(i);
		
		// using our original syntax, but doing the same thing we did inline before
		Comparator<Integer> c = (Integer a, Integer b) -> a - b;
		Arrays.sort(nums, c);
		
		for (Integer i : nums)
			System.out.println(i);

	}

}

// you can make a functional interface without this annotation, as long as you only have one abstract method
@FunctionalInterface
interface Func1 {
	String getString();
	// when using the annotation, we can see that the second method is not allowed
//	int getNumber();
	// you CAN have default methods, because they are implemented
	default void test() {};
}

class Func1Imp implements Func1 {

	@Override
	public String getString() {
		return "Implemented!";
	}
	
}
