package com.skillstorm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueues {

	public static void main(String[] args) {
		
		// PRIORITY QUEUE AND SORTING
		
		Queue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(2);
		pq.offer(9);
		pq.offer(-34);
		pq.offer(11);
		pq.offer(100);
		pq.offer(0);
		pq.offer(-3545);
		pq.offer(5);
		pq.offer(66);
		pq.offer(42);
		pq.offer(100000);
		
		// this does NOT print in any sensible order
		System.out.println(pq);
		
		while (!pq.isEmpty())
			System.out.println(pq.poll());
		
		Queue<String> pqs = new PriorityQueue<>();
		pqs.add("abc");
		pqs.add("ABC");
		pqs.add("xyz");
		pqs.add("xYz");
		pqs.add("123");
		
//		System.out.println(pqs);
//		
//		while (!pqs.isEmpty())
//			System.out.println(pqs.poll());
		
		// numbers and Strings have a natural sort order (lowest-highest and alpha order)
		// BUT, most objects don't, and if we want to sort numbers, say, backward, we need a Comparator
		
		Queue<Integer> pq2 = new PriorityQueue<>(new BackwardIntegerSort());
		
		pq2.offer(2);
		pq2.offer(9);
		pq2.offer(-34);
		pq2.offer(11);
		pq2.offer(100);
		pq2.offer(0);
		pq2.offer(-3545);
		pq2.offer(5);
		pq2.offer(66);
		pq2.offer(42);
		pq2.offer(100000);
		
		// this does NOT print in any sensible order
		System.out.println(pq2);
		
		while (!pq2.isEmpty())
			System.out.println(pq2.poll());
		
		

	}

}

// to implement Comparator, just implement it like any other interface and choose the type of Object you're comparing
class BackwardIntegerSort implements Comparator<Integer> {

	@Override
	public int compare(Integer x, Integer y) {
//		if (x > y)
//			return -1;
//		if (y > x)
//			return 1;
//		return 0;
		return y - x;
	}
	
}

class ForwardIntegerSort implements Comparator<Integer> {

	@Override
	public int compare(Integer x, Integer y) {
//		if (x > y)
//			return 1;
//		if (y > x)
//			return -1;
//		return 0;
		return x - y;
	}
	
}
