package com.skillstorm;

public class Operators {

	public static void main(String[] args) {
		
		// OPERATORS IN JAVA
		
		/*
		 * all the same operators you're familiar with work here, too
		 * 
		 * Mathematical Operators
		 *  +
		 *  -
		 *  *
		 *  /
		 *  %
		 *  =
		 *  
		 * PEMDAS applies -- 1 * 4 + 7 - (9 * 2)
		 * 
		 * Incremental Operators
		 * these ONLY work on variables, not primitive values, so I can't say 1++
		 * 
		 * ++
		 * --
		 * 
		 * += -> if x = 5, after x += 5, x = 10
		 * -=
		 * *=
		 * /=
		 * %=
		 * 
		 * for ++/--, prefix/postfix rules apply
		 * 
		 * 
		 * Boolean Operators
		 * 
		 * Comparison
		 * == (no need for triple-equals, because everything in Java is already strongly-typed)
		 * <
		 * >
		 * <=
		 * >=
		 * !=
		 * 
		 * Relational
		 * && - and
		 * || - or
		 * & - bitwise and
		 * | - bitwise or
		 * ^ - XOR...only ONE can be true, not both
		 * !(a && b) - NAND
		 * !(a || b) - NOR
		 * !^ = Not XOR
		 * 
		 * 
		 */
		
		// watch your increments!
		// in this case, the value of i is used by the println() method BEFORE being incremented
		for(int i = 0; i < 10; ) {
			System.out.println(i++);
		}
		
//		Person person = new Person("Jon");
		Person person = null;
		
		// if we used bitwise-and here, we'd throw a NullPointerException when we did the second check
		// by using double-and, when the first check returns false, we ignore the second one
		if(person != null && person.name.equals("Jon")) {
			System.out.println("Success!");
		} else {
			System.out.println("Failure!");
		}

	}

}

class Person {
	String name;
	
	public Person(String name) {
		this.name = name;
	}
}
