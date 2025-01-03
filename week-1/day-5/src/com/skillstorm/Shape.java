package com.skillstorm;

public abstract class Shape {
		
	int sides;
	
	Shape(int sides) {
		this.sides = sides;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
}

class Triangle extends Shape {
	
	Triangle(int sides) {
		super(sides);
	}
	
	@Override
	public String toString() {
		return "I am a Triangle, and I have " + this.sides + " sides.";
	}
	
}

class Square extends Shape {
	
	Square(int sides) {
		super(sides);
	}
	
	@Override
	public String toString() {
		return "I am a Square, and I have " + this.sides + " sides.";
	}
	
}

class Pentagon extends Shape {
	
	Pentagon(int sides) {
		super(sides);
	}
	
	@Override
	public String toString() {
		return "I am a Pentagon, and I have " + this.sides + " sides.";
	}
	
}