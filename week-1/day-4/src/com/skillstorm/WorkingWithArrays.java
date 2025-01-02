package com.skillstorm;

import java.util.Arrays;

public class WorkingWithArrays {

	public static void main(String[] args) {
		
		// ARRAYS IN JAVA
		
		/*
		 * cannot change size once initialized
		 * arrays are typed -- each slot must hold the declared type OR a child type
		 * exist on the heap, along with their references/values, etc.
		 * they are iterable
		 * fast!
		 * contiguous in memory
		 * can store anything -- objects or primitives, collections, etc.
		 * access is via index (bracket notation)
		 * 0-indexed
		 * memory-efficient
		 */
		
		int[] nums;
//		int nums2[]; // don't like this as much, but it works
		nums = new int[5];
		nums = new int[6];
		
		int[] nums2 = new int[10];
		
//		System.out.println(nums[0]);
		
		/*
		 * default values for array slots AND object properties
		 * all numerical values = 0
		 * all Objects = null
		 * all Strings = null
		 * all booleans = false
		 */
		
//		for (int num : nums)
//			System.out.println(num);
		
		// you can also use an array literal to initialize the size and provide starting values
		int[] nums3 = { 4, 1, 3, 0, 7, 8 };
		
		for (int num : nums3)
			System.out.println(num);
		
		System.out.println(nums3[4]);
		nums3[4] = 100;
		System.out.println(nums3[4]);
		
		int[][] twoDee = new int[3][3];
		
		int[][] twoDee2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		System.out.println(twoDee2[0][2]);
		
		String[] nerds = { "Jonathan", "Laurel", "Jeffrey" };
		
		String[] nerds2 = nerds;
		
		nerds[0] = "Jon";
		
		// without cloning, the variables point to the same object; changing one changes the other
		System.out.println(nerds2[0]);
		
		// this creates a separate, unique copy of the original array
		nerds2 = nerds.clone();
		
		System.out.println(nerds[0]);
		System.out.println(nerds2[0]);
		
		// this ONLY changes nerds, not nerds2
		nerds[0] = "Jonathan";
		
		System.out.println(nerds[0]);
		System.out.println(nerds2[0]);
		
		int[] nums4 = { 3, 7, 1, 0, 7, 3, 5, 4 };
		
		// arrays have a length property, as opposed to other collections' .size() method
		System.out.println(nums.length);
		
		// you can use the Arrays utility class to access additional useful methods
		Arrays.sort(nums4);
		
		for (int num : nums4)
			System.out.println(num);
		
		// use this to print an array how you'd expect it to print
		// normally just prints the memory address(ish)
		System.out.println(Arrays.toString(nums4));
		
		// you can lump subtypes into an array of a parent type
		// NOT the other way around!
		Food[] food = { new Food(), new ChiliDog(), new Food(), new ChiliDog() };
		
		
	}

}

class Food {
	
}

class ChiliDog extends Food {
	
}






