package com.skillstorm;

public class Polymorphism {

	public static void main(String[] args) {
		
		// POLYMORPHISM IN JAVA
		
		/*
		 * overriding -- reimplementing a parent method (runtime polymorphism)
		 * overloading -- different parameters, same method name, in the same class (compile-time polymorphism)
		 * 
		 * if there's an intact override chain, the most specific version of the method will run
		 * 
		 * static methods DO NOT override!!
		 */
		
		A a = new A();
		A b = new B();
		A c = new C();
		
		A[] as = { a, b, c };
		for (A element : as)
			element.sayName();
		
		// this is an improper way to call a static method
		// it belongs to the class, NOT the instance
		// whatever the compiler thinks the object is (an A, in this instance), it'll call that version of the method
		// it will NOT override to the most specific class
//		c.sayClass();
		
		// call static methods on the class itself, not an instance
		C.sayClass();
		
		// for overloading, take a look at Arrays.sort() to see how many options you can find for different use cases!

	}

}

class A {
	// when you override, you CAN increase visibility (protected -> public, for instance)
	// you CANNOT decrease visibility
	void sayName() {
		System.out.println("A");
	}
	
	public static void sayClass() {
		System.out.println("Class A");
	}
	
	// when overloading, you CANNOT have the same number of parameters with the same types
	// you CAN have different numbers, reorder, etc.
	// but you MUST have the same method name
	public void overload() {}
	public void overload(int x) {}
	public void overload(String s) {}
	public void overload(int x, String s) {}
	public void overload(String s, int x) {}
	public void overload(int x, int y) {}
	public void overload(short x, short y) {}
	// I can't do this, because the return type is ignored when choosing which method to run
	// and this matches the one above
	// public short overload(short x, short y) {}
	
}

class B extends A {
	@Override
	protected void sayName() {
		System.out.println("B");
	}
	
	public static void sayClass() {
		System.out.println("Class B");
	}
	
	// you can do both at the same time (OR and OL)
	@Override
	public void overload() {}
	@Override
	public void overload(int x) {}
	@Override
	public void overload(String s) {}
	@Override
	public void overload(int x, String s) {}
	@Override
	public void overload(String s, int x) {}
	@Override
	public void overload(int x, int y) {}
	@Override
	public void overload(short x, short y) {}
}

class C extends B {
	@Override
	public void sayName() {
		System.out.println("C");
	}
	
	public static void sayClass() {
		System.out.println("Class C");
	}
}
