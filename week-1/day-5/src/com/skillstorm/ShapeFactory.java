package com.skillstorm;

public class ShapeFactory {
	
	// THE FACTORY PATTERN
	
	/*
	 * the Factory Pattern conceal the creation of objects behind a "factory"
	 * the user can only see the factory but gets objects from other classes
	 * they don't request specific objects
	 * they feed in data and get back something that matches their request
	 */
	
	public static Shape makeShape(int sides) {
		switch (sides) {
			case 3:
				return new Triangle(sides);
			case 4:
				return new Square(sides);
			case 5:
				return new Pentagon(sides);
			default:
				throw new IllegalArgumentException("Number of sides must be 3-5.");
		}
	}
	
}
