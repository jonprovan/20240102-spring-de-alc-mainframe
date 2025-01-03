package com.skillstorm;

public class Abstraction {

	public static void main(String[] args) {
		
		// ABSTRACTION IN JAVA
		
		/*
		 * hiding implementation details from the user, either a person or a class/program
		 * 
		 * an API is a great example -- we only know the endpoints, not what happens when we hit them
		 * 
		 * the factory pattern is a classic coding pattern that uses abstraction
		 * 
		 * inside Java, we have abstract classes and interfaces
		 * 
		 * DIFFERENCES?
		 * 
		 * Abstract classes CAN have implemented methods, interfaces CANNOT
		 * Abstract classes can ALSO have unimplemented methods
		 * Abstract classes use an IS-A relationship, interfaces are more CAN-DO
		 * These are often "contracts" -- the class extending/implementing them MUST implement the abstract methods
		 * Neither can be directly instantiated
		 * Subclasses can ONLY inherit from one abstract class
		 * HOWEVER, subclasses can implement as many interfaces as they like, as well as extend something AND implement the interfaces
		 */
		
		// can't do this, because the class is abstract
		// CellPhone cp = new CellPhone("Blue", 999.99);
		
		// I can do this...
		CellPhone specificIPhone = new SpecificIPhone("Blue", 999.99, 13, "Pro Max");
		
		specificIPhone.declareStats();
		System.out.println(specificIPhone.call("Ian"));
		System.out.println(specificIPhone.hangUp("Ian"));
		
		// if we implement multiple interfaces but assign a reference type from one, we won't have access to the methods from the other
		Piano piano = new Piano();
		
		piano.play();
		System.out.println(piano.clean());
		System.out.println(piano.tune());
		System.out.println(piano.sell());
		piano.conflictTest();

	}

}

// create an abstract class using the abstract keyword
abstract class CellPhone {
	
	// properties work the same
	String color;
	double price;
	
	// we CAN have constructors to make subclass chaining easier
	// but we still cannot instantiate this class
	CellPhone(String color, double price) {
		this.color = color;
		this.price = price;
	}
	
	// you CAN write implemented methods in an abstract class
	void declareStats() {
		System.out.println("I am " + this.color + ", and I cost $" + this.price + ".");
	}
	
	// you can ALSO include abstract methods that do not provide implementation
	// subclasses MUST implement these methods
	abstract String call(String recipient);
	
	abstract String hangUp(String recipient);
	
}

abstract class iPhone extends CellPhone {
	
	int modelNumber;
	
	public iPhone(String color, double price, int modelNumber) {
		super(color, price);
		this.modelNumber = modelNumber;
	}
	
	String call(String recipient) {
		return "Hello, " + recipient + "!";
	}
	
	// if our middle class is ALSO abstract, we don't have to implement all the methods
	// we can omit and pass the implementation along to a future child
	
//	String hangUp(String recipient) {
//		return "Goodbye, " + recipient + "!";
//	}
	
}

class SpecificIPhone extends iPhone {
	
	String suffix;
	
	public SpecificIPhone(String color, double price, int modelNumber, String suffix) {
		super(color, price, modelNumber);
		this.suffix = suffix;
	}
	
	// here, we're implementing the remaining abstract method from the original class
	String hangUp(String recipient) {
		return "Goodbye, " + recipient + "!";
	}
	
}

// interfaces
interface MusicalInstrument {
	
	// properties
	// the only properties allowed in interfaces are public, static, final ones
	// think of this like a class constant
	boolean soundsGreat = true;
	
	void play();
	String clean();
	String tune();
	// this method stub exists in both interfaces
	void conflictTest();
	
	// you CAN provide implementation via default methods
	// this is not common and doesn't make sense for most interface use cases
	default void whyCanIDoThis() {
		System.out.println("Who knows?");
	}
	
}

interface CollectorsItem {
	
	double sell();
	// this method stub exists in both interfaces
	void conflictTest();
	
}

// you CAN extend from an interface, but this MUST happen with another interface
// to actually create a complete class from an interface, you must use implements
class Piano implements MusicalInstrument, CollectorsItem {

	@Override
	public void play() {
		System.out.println("Plinka-plink.");
	}

	@Override
	public String clean() {
		return "88 keys, shined up nice.";
	}

	@Override
	public String tune() {
		return "Grandma's piano is beyond hope.";
	}

	@Override
	public double sell() {	
		return 1.99;
	}
	
	@Override
	public void conflictTest() {
		System.out.println("Conflict avoided...so passive-aggressive.");
	}
	
}




