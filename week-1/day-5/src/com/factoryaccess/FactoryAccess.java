package com.factoryaccess;

import com.skillstorm.Shape;
import com.skillstorm.ShapeFactory;

public class FactoryAccess {

	public static void main(String[] args) {

		/*
		 * here, we reach out to our factory to get a shape
		 */
		
		Shape shape1 = ShapeFactory.makeShape(3);
		
		System.out.println(shape1);
		
		Shape shape2 = ShapeFactory.makeShape(4);
		
		System.out.println(shape2);
		
		Shape shape3 = ShapeFactory.makeShape(5);
		
		System.out.println(shape3);

	}

}
