package com.skillstorm;

public class Methods {

	public static void main(String[] args) {
		
		// METHODS IN JAVA
		
		/*
		 * JavaScript functions are equivalent in concept to Java methods
		 * 
		 * methods MUST live within a class and CANNOT live within another method
		 * 
		 * Elements of a method we need:
		 * access modifier
		 * other modifier(s)
		 * return type
		 * name
		 * parameter type(s)
		 * 
		 * static methods can ONLY access other static methods or static properties
		 * 
		 * Access Modifiers
		 * ** cannot be used inside a method, only with class properties/methods
		 * public -- anywhere
		 * protected -- only within the package AND child classes, even if those child classes are in another package
		 * default -- only within the package
		 * private -- only things within the class
		 */
		
		// static method/variable calls turn to italics to indicate their staticness
		printHi();
		
		System.out.println(getNumber());
		
		final int x;
		x = 11;
		// can't do this, because x is final and has been assigned a value
//		x = 12;
		

	}
	
	public static void printHi() {
		System.out.println("Hi!");
	}
	
	public static int getNumber() {
		return getFirstNumber() + getSecondNumber();
	}
	
	public static int getFirstNumber() {
		return 10;
	}
	
	public static int getSecondNumber() {
		return 20;
	}

}

class Wolf {
	public final void speak() {
		System.out.println("Hooooowl!");
	}
}

class WolfPup extends Wolf {
	// can't do this, because the method is final in the parent class
//	public void speak() {
//		System.out.println("Yip!");
//	}
}
