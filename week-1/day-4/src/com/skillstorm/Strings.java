package com.skillstorm;

public class Strings {

	public static void main(String[] args) {
		
		// STRINGS IN JAVA
		
		/*
		 * Strings are objects in Java
		 * They are arrays of chars
		 * They must be checked and assessed a little differently than primitives
		 */
		
		String str1 = "First String";
		String str2 = new String("Second String");
		String str3 = str1 + str2;
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		// many useful methods are available for String objects
		System.out.println(str1.charAt(0));
		System.out.println(str1.contains("irs"));
		
		// this works (String literals in the pool)
		System.out.println("abc" == "abc");
		// this doesn't, because they have different memory addresses
		System.out.println(new String("abc") == new String("abc"));
		// this works, because the String class has a properly-overridden .equals() method which compares the values
		System.out.println(new String("abc").equals(new String("abc")));
		
		// BEST PRACTICE = always use .equals() with Strings
		
		// Strings can use escape characters
		System.out.println("Print this with quotes: \"Hi!\"");
		System.out.println("First Line\nSecond Line");

	}

}
