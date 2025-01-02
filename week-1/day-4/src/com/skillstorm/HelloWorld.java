// this is a comment

// this is a package declaration
// sets up a folder structure
// also gives us some access controls
// follows a reverse-domain-name structure in general
// it MUST come before the class declaration AND before the imports
package com.skillstorm;

// if we have imports, they go here
import java.io.*;

// whitespace does not matter in Java

// this is a class declaration
// usually, we only have one class in a file, but you can have multiple
// however, you may ONLY have ONE public class
// Pascal Case for class names 
public class HelloWorld {
	
	// the main method is the starting point for our application
	// also the starting point for the main app stack/call stack
	// syntax -> <access modifier> <other modifiers> <return type> main( <array of String> variable name )
	public static void main(String[] args) {
		
		// this command prints out whatever's in the parentheses
		// double-quotes for String, single-quotes for char
		System.out.println("Hello, World!");
		System.out.println('C');
		
		boolean test = false;
		
		System.out.println(test);

	}

}
