package com.skillstorm;

public class ControlFlow {

	public static void main(String[] args) {
		
		// CONTROL FLOW IN JAVA
		
		/*
		 * What order will my code execute?
		 * Functional programming land still
		 * 
		 * Branching:
		 * if
		 * else
		 * else if
		 * switch
		 * 
		 * Loops:
		 * while
		 * do-while
		 * standard for
		 * enhanced for (foreach)
		 * 
		 */
		
		// branching
		
		// if
		// conditions must resolve to booleans (no truthy-falsy)
		if (true) {
			System.out.println("The if was true.");
		}
		
		if (true)
			System.out.println("You can avoid the brackets if you only have one line.");
		
		// else
		if (false) {
			System.out.println("The if/else was true.");
		} else {
			System.out.println("The if/else was false.");
		}
		
		// else if
		// you can have as many else ifs as you like
		// you may only have one else, and it has to be at the end
		if (false)
			System.out.println("If");
		else if (false)
			System.out.println("Else If 1");
		else if (true)
			System.out.println("Else If 2");
		else
			System.out.println("Else");
		
		// switch
		// you cannot check against a boolean (won't compile)
		// all other types are okay (primitives, objects, etc.)
		String checkString = "abc";
		
		// you can add a default case, like an else
		// it will execute if nothing else matches
		// it DOES NOT have to be last
		// we insert breaks between cases to prevent cascading
		switch (checkString) {
			case "abc" :
				System.out.println("Alphabetical");
				break;
			case "zyx" :
				System.out.println("Reverse Alphabetical");
				break;
			case "123" :
				System.out.println("Numerical");
				break;
			default :
				System.out.println("Nothing Matched!");
				break;
		}
		
		// you won't always want or need the break statements!
		int counter = 3;
		
		switch (counter) {
			case 5 :
				System.out.println("5...");
			case 4 :
				System.out.println("4...");
			case 3 :
				System.out.println("3...");
			case 2 :
				System.out.println("2...");
			case 1 :
				System.out.println("1...");
			default :
				System.out.println("Liftoff!!");
		}
		
		// LOOPS
		
		// while
		// condition is evaluated BEFORE the first iteration
		int count = 0;
		
		while (count < 3) {
			System.out.println(count++);
		}
		
		// do-while
		// condition is evaluated AFTER the first iteration
		// it will ALWAYS execute at least once
		
		count = 5;
		
		do {
			System.out.println(count++);
		} while (count < 3);
		
		// standard for
		// good for accessing the loop index
		// good for doing something a specific number of times
		for (int i = 0; i < 5; i++) {
			System.out.println("Current loop index is: " + i);
		}
		
		int internalInt = 0;
		
		for (;;) {
			if (internalInt == 3)
				break;
			System.out.println(internalInt);
			internalInt++;
		}
		
		for (int i = 0, j = 0; i < 3 && j < 5; i++, j++) {
			System.out.println(String.format("i = %d and j = %d", i, j));
		}
		
		int[] nums = { 3, 6, 9, 12, 15 };
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		// enhanced for
		// much easier to use on collections than a regular for
		// but, we don't have access to the index and other controlling properties
		// it will execute once for each element in the collection
		// the collection must be iterable
		for (int num : nums) {
			System.out.println(num);
		}
		
	}

}
