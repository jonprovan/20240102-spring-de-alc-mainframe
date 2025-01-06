package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Comparisons {

	public static void main(String[] args) {
		
		// For our custom objects, we can either use Comparator OR Comparable
		// Comparator is a third-party object that compares two objects of our custom type
		// Comparable is implemented by our object itself and compares it to another object of the same type
		
		PageCountComparator pcc = new PageCountComparator();
		TitleComparator tc = new TitleComparator();
		
		// if Book implements Comparable, we can leave out the parameter on the PQ, and it'll use the Comparable
		// if Book does not, we MUST include a Comparator
		// if Book implements Comparable and we add a Comparator, the Comparator overrides the Comparable
		Queue<Book> books = new PriorityQueue<>();
		
		books.offer(new Book("Clean Code", 1));
		books.offer(new Book("Harry Potter and the All Of Them", 3000));
		books.offer(new Book("Percy Jackson and the Olympians", 2000));
		books.offer(new Book("The Hobbit", 300));
		books.offer(new Book("Dad Jokes", 152));
		books.offer(new Book("Unfinished Opus", 1));
		books.offer(new Book("Coding For Dummies", 3000));
		books.offer(new Book("The ABCs of Powerwashing", 300));
		books.offer(new Book("The A Hitchhiker's Guide To The Galaxy, Title Pending", 3000));
		
		// this doesn't run without either a Comparable or Comparator
		System.out.println(books);
		
		while (!books.isEmpty())
			System.out.println(books.poll());
		
		// these can be used with Arrays.sort() and Collections.sort() as well
		Book[] someBooks = {
			new Book("The Sounds Of Classroom Silence", 10000),
			new Book("Fahrenheit 451", 375),
			new Book("Refactoring with C#", 354)
		};
		List<Book> newBooks = new ArrayList<>(Arrays.asList(someBooks));
		
		System.out.println(newBooks);
		
		// we can feed our Comparators into the sort() method, or leave it out to use our Comparable's natural order
		Collections.sort(newBooks, tc);
		
		System.out.println(newBooks);
	}

}

// to give Book a natural sort order, we implement Comparable
class Book implements Comparable<Book> {
	String title;
	int pageCount;
	
	public Book(String title, int pageCount) {
		this.title = title;
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", pageCount=" + pageCount + "]";
	}

	// only one parameter here, because we're comparing THIS Book to ANOTHER book
	@Override
	public int compareTo(Book other) {
		
		if (this.pageCount == other.pageCount) {
			String thisTitle = this.title;
			String otherTitle = other.title;
			if (thisTitle.startsWith("The "));
				thisTitle = thisTitle.substring(4);
			if (otherTitle.startsWith("The "))
				otherTitle = otherTitle.substring(4);
			
			return thisTitle.compareTo(otherTitle);
		}
		return this.pageCount - other.pageCount;
	}

}

// to compare books by page count only
class PageCountComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		
		return b2.pageCount - b1.pageCount;
	}
	
}

// to compare books by title only
class TitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		
		return b1.title.compareTo(b2.title);
	}
	
}
