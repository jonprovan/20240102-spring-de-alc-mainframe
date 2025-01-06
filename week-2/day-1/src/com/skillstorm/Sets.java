package com.skillstorm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
		// SETS IN JAVA
		
		/*
		 * stores unique values, i.e., no duplicates are allowed!
		 * unordered
		 * Set is an interface, so we must instantiate with a more specific type
		 * cannot store primitives, like other Collections
		 * there are sorted Sets we can use if we like
		 * 
		 */
		
		// can't instantiate Set directly, so we commonly use HashSet (unordered)
		Set<String> stringSet = new HashSet<>();
		
		stringSet.add("Jeffrey");
		stringSet.add("Laurel");
		System.out.println(stringSet.add("Steven"));
		
		System.out.println(stringSet);
		
		System.out.println(stringSet.add("Steven"));
		
		System.out.println(stringSet);
		
		String[] names = { "Lauren", "Ian", "Jonathan", "Miranda", "Jeffrey", "Laurel" };
		stringSet.addAll(Arrays.asList(names));
		
		System.out.println(stringSet);
		
		// some implementations include sorting
		// elements are sorted on insertion
		// for custom objects, you can use Comparable/Comparator to sort them
		Set<Integer> numberSet = new TreeSet<>();
		
		numberSet.add(5);
		numberSet.add(11);
		numberSet.add(-3);
		numberSet.add(0);
		numberSet.add(-123);
		
		System.out.println(numberSet);
		
		// the contains() method is useful here
		System.out.println(stringSet.contains("Ian"));

	}

}
