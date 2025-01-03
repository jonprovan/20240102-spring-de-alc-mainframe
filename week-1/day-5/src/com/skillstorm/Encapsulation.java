package com.skillstorm;

public class Encapsulation {

	public static void main(String[] args) {
		
		// ENCAPSULATION IN JAVA
		
		/*
		 * public, protected, default (none), private
		 * 
		 * Full encapsulation -- all private properties, getter/setter methods where necessary
		 */
		
		JokeBook jb1 = new JokeBook();
		
		// can't do this, because the variable is private
//		System.out.println(jb1.pageCount);
		
		System.out.println(jb1.getPageCount());
		
		System.out.println(jb1.isFunny());
		
		jb1.setFunny(true);
		
		System.out.println(jb1.isFunny());
		
		// testing our Rectangle class
		Rectangle rectangle = new Rectangle(4, 8);
		
		System.out.println(rectangle);
		
		rectangle.setHeight(16);
		
		System.out.println(rectangle);
		
		// if we just type 20, Java thinks it's an int, but the method expects a short, so we have to cast it
		jb1.setPageCount((short)20);

	}

}

class JokeBook {
	
	private short pageCount;
	private String coverColor;
	private boolean funny;
	
	// getters
	public short getPageCount() {
		return this.pageCount;
	}
	
	public String getCoverColor() {
		return this.coverColor;
	}
	
	public boolean isFunny() {
		return this.funny;
	}
	
	// setters
	// some simple validation in here to ensure a proper page count
	public void setPageCount(short pageCount) {
		if (pageCount <= 0 || pageCount >= 1001)
			throw new IllegalArgumentException("Page count must be between 1 and 1000");
		else
			this.pageCount = pageCount;
	}
	
	public void setCoverColor(String coverColor) {
		this.coverColor = coverColor;
	}
	
	public void setFunny(boolean funny) {
		this.funny = funny;
	}
	
}

class Rectangle {
	
	private int width;
	private int height;
	private int area;
	
	// constructors
	// we don't need to take in area here; we compute it
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		this.area = this.width * this.height;
	}
	
	// when we create the first constructor, we no longer have access to the default no-args constructor
	// we must create our own no-args constructor in order to continue using it
	public Rectangle() {
		// this is optional most of the time
		// it runs the constructor for the superclass, in this case, Object.class
		super();
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
		this.area = this.width * this.height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
		this.area = this.width * this.height;
	}
	
	public int getArea() {
		return area;
	}
	
	// we can remove this because there's no real way to do it properly
//	public void setArea(int area) {
//		this.area = area;
//	}
	
	// a generated toString() method
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", area=" + area + " square units]";
	}
	
}




