package com.skillstorm;

public class StackHeap {

	public static void main(String[] args) {
		
		// SOME STACK-HEAP JOY FOR THURSDAY
		
		int x = 7;
		int y = x + 22;
		int z = x;
		y = z;
		
		int[] nums = { 2, 4, 6, 8 };
		System.out.println(nums);
		
		nums = null;
		System.out.println(nums);
		
		HotDog hd1 = new HotDog(true);
		HotDog hd2 = new HotDog(false);
		HotDog hd3 = new HotDog(true);
		
		HotDog[] hds = { hd1, hd2, hd3 };
		
		hd2 = null;
//		hds[1] = null;
		
//		hd2.isTasty = true;
		
		System.out.println(hds[1].isTasty);

	}

}

class HotDog {
	public boolean isTasty;
	
	public HotDog(boolean isTasty) {
		this.isTasty = isTasty;
	}
}
