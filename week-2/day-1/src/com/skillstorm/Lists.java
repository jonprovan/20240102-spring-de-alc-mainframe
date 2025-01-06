package com.skillstorm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lists {

	public static void main(String[] args) {
		
		// LISTS IN JAVA
		
		/*
		 * List is an interface in Java
		 * You cannot instantiate a List, you must instantiate some type of List
		 * 
		 * In general, Lists are/have:
		 * not a fixed size
		 * ordered
		 * iterable
		 * we can remove "slots" and the others shift to take their place
		 * typed -- anything that is the type or a child of that type can be stored in the List
		 * ONLY able to hold objects, not primitives
		 * several useful methods common to all List subclasses we can use, like .size()
		 * 
		 * ArrayList and LinkedList are the main two we'll work with
		 * 
		 * ArrayList
		 * Under the hood, this structure has an actual array
		 * Very fast access to individual elements
		 * Insert/remove is slower, because all other elements have be copy-shifted
		 * The underlying array expands/contracts as you add/remove elements
		 * 
		 * LinkedList
		 * Each element lives in a "node" which stores the value and pointers to the previous/next values
		 * Each node lives in a separate spot in memory, not necessarily contiguous
		 * Doubly-linked in Java (pointers in both directions)
		 * Faster to retrieve elements toward the end
		 * We can use it as a Stack/Queue/Deque by accessing from either end
		 * To access an element, we must traipse through the LinkedList from one end until we get to it (slower access)
		 * Insertion/removal are very fast because we only need to change the pointers
		 */
		
		// ArrayLists
		
		// typing this as a List to see the List-specific methods
		// if you type it as an ArrayList, you'll see some other methods
		// some of which deal with manipulating the size of the underlying array, etc.
		List<String> stringList = new ArrayList<>();
		
		stringList.add("My First String");
		
		// can't do this because an Integer is not a String
//		stringList.add(new Integer(3));
		
		// add puts an element at the end/right
		stringList.add("My Second String");
		
		System.out.println(stringList);
		
		// you can remove by index
		stringList.remove(1);
		
		System.out.println(stringList);
		
		// or by element, which removes the first appearance of this String
		stringList.remove("My First String");
		
		System.out.println(stringList);
		
		String[] strings = { "one", "two", "three" };
		
		// you can also add all of a Collection to the List at the same time
		stringList.addAll(Arrays.asList(strings));
		
		System.out.println(stringList);
		
		// use size() to get the length
		System.out.println(stringList.size());
		
		// use contains() to check if an element exists within the List
		System.out.println(stringList.contains("two"));
		
		String[] check = { "two", "three" };
		
		System.out.println(stringList.containsAll(Arrays.asList(check)));
		
		// LinkedList
		// LinkedList implements several other interfaces
		// which provide functionality for stacks, queues, and deques (double-ended queues)
		
		LinkedList<Integer> integerList = new LinkedList<>();
		
		// all the List methods work here as well
		
		// STACK VS QUEUE
		
		/*
		 * Stack = Last In, First Out (LIFO)
		 * Queue = First In, First Out (FIFO)
		 * Deque = Like a Queue, but works from both sides/directions
		 */
		
		// Stack IS a class in Java...
		Stack<Integer> myStack = new Stack<>();
		
		myStack.push(1);
		myStack.push(3);
		System.out.println(myStack);
		
		// however, this is an older, deprecated class, so DON'T USE IT!! (use Deque instead)
		
		// Queue and Deque in Java are interfaces, so you need a collection under the hood
		Queue<Integer> myQueue = new LinkedList<>();
		
		// add an element with offer
		myQueue.offer(1);
		myQueue.offer(2);
		myQueue.offer(3);
		
		System.out.println(myQueue);
		
		// remove the first element with poll
		Integer x;
		System.out.println(x = myQueue.poll());
		System.out.println(x);
		
		System.out.println(myQueue);
		
		System.out.println(myQueue.peek());
		
		System.out.println(myQueue);
		
		// using a Deque as a Stack
		Deque<Integer> myStack2 = new LinkedList<>();
		
		myStack2.push(6);
		myStack2.push(7);
		myStack2.push(8);
		
		System.out.println(myStack2);
		
		System.out.println(myStack2.pop());
		
		System.out.println(myStack2);
		
		System.out.println(myStack2.peek());
		
		System.out.println(myStack2);
		
		// can also use a Deque as a Deque
		// remember to use offer and poll instead of their equivalents
		// this avoids certain exceptions if the Deque is empty, etc.
		Deque<Integer> myDeque = new LinkedList<>();
		
		myDeque.offerLast(11);
		myDeque.offerLast(12);
		myDeque.offerLast(13);
		myDeque.offerLast(14);
		myDeque.offerLast(15);
		
		System.out.println(myDeque);
		
		myDeque.offerFirst(16);
		
		System.out.println(myDeque);
		
		System.out.println(myDeque.pollLast());
		
		System.out.println(myDeque);
		
		System.out.println(myDeque.pollFirst());
		
		System.out.println(myDeque);
		
		
	
	}

}
