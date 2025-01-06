package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class LambdasAndStreams {

	public static void main(String[] args) {
		
		// LAMBDAS AND STREAMS IN JAVA
		
		/*
		 * Lambda syntax is a shorthand way of writing functions in Java
		 * 
		 * Generally, they look like:
		 * (int x, int y) -> { return x + y; }
		 * 
		 * if you have no parameters, you must include the parentheses ... () -> {}
		 * if you have one parameters, you don't have to ... int x -> {}
		 * if you have multiple, you DO have to ... (int x, int y) -> {}
		 * 
		 * if you have only one code statement, you don't need the brackets ... () -> System.out.println("Hi")
		 * if you have multiple statements, you do ... () -> { System.out.println("Hi); return "Bye"; }
		 * also, if you don't use brackets, you cannot use the return keyword ... (int x, int y) -> x + y
		 * but, if you do use brackets you have to use the return keyword, assuming you're returning something ... (int x, int y) -> { return x + y; }
		 * 
		 * Lambdas are useful when we need to feed in a function/method as a parameter
		 * 
		 * One of the places we use them a LOT is with the Java Stream API
		 * 
		 * In JS, we do these higher-order functions on arrays
		 * In Java, we do them on Streams
		 * 
		 * A Stream is an element-by-element flow of the items in a collection
		 * Streams, once operated on, are no longer usable!
		 * If we want to work with it again, we have to recreate it from the collection
		 * Some operations are terminal, some are not
		 * In order for ANY operations in the chain to occur, we need a terminal operation at the end
		 * 
		 * The processing of elements does not happen in the order we'd expect...
		 */
		
		// Streams
		Integer[] nums = { 1, 2, 3, 4, 5 };
		
		List<Integer> numsList = new LinkedList<>(Arrays.asList(nums));
		
		System.out.println(numsList);
		
		// you can create a Stream directly from values
		Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5);
		
		// but you can recreate a Stream from a List more quickly by doing it this way
		numsList.stream();
		
		// forEach
		// for each element in the stream, do something and return nothing
		// this a termimal operation
		// this requires a Consumer function, i.e., one that takes in something and returns void
//		numsList.stream().forEach(element -> {
//			System.out.println(element * element);
//		});
		
		
		// map
		// for each element in the stream, do something AND return something to a new Stream
		// this is a non-terminal operation that requires an ensuing terminal operation to function
		// this requires a Producer function, i.e., one that takes in something and returns something
		// adding a forEach here to see the results -- without it, NOTHING HAPPENS!
		// note that each element is taken all the way through the chain before moving on to the second
//		numsList.stream().map(element -> {
//			System.out.println(element * element);
//			return element * element;
//		}).forEach(element -> {
//			System.out.println(element * element);
//		});
		
		
		// filter
		// for each element in the stream, see if it meets the criteria
		// if it does, return it to a new stream UNPROCESSED!
		// if it doesn't, remove it from further processing
		// this is also non-terminal
		// this requires a Predicate function, which takes in something and returns true (boolean) if the conditions are met
		numsList.stream().filter(element -> {
			
//			if (element <= 3)
//				return true;
//			else
//				return false;
			
			// this is equivalent but snappier!
			return element <= 3;
		}).forEach(element -> {
			System.out.println(element);
		});
		
		
		// reduce
		// take all the elements in the stream and return a single value
		// this is another terminal operation
		// it returns something, but it doesn't return a stream
		// this requires a BinaryOperator/Accumulator function which takes two parameters and does something with them
		
		// the first parameter is an optional starting value, in this case 0
		// the second is the BinaryOperator function
		// if you do not include the optional starting value, the result will be an Optional, and you'll have to .get() the value out
		Integer x = numsList.stream().reduce(0, (Integer a, Integer b) -> {
			return a + b;
		});
		
		System.out.println(x);
		
		String[] names = { "Jonathan", "Ian", "Miranda", "Lauren", "Laurel", "Steven", "Jeffrey" };
		
		List<String> stringList = new LinkedList<>(Arrays.asList(names));
		
		String str = stringList.stream().reduce("", (String a, String b) -> {
			if (a.length() < b.length())
				return b;
			else
				return a;
		});
		
		System.out.println(str);
		
		System.out.println();
		
		VideoGame[] games = {
			new VideoGame("Horizon Zero Dawn", 1, 50),
			new VideoGame("Overcooked", 4, 20),
			new VideoGame("Contra", 2, 4),
			new VideoGame("Powerwashing Simulator", 1, 75),
			new VideoGame("Modern Warfare", 64, 40),
			new VideoGame("BomberMan Z", 5, 15)
		};
		
		/*
		 * change all titles to have an X at the end
		 * games with even numbers of play hours
		 * games with fewer than 4 concurrent players
		 * 1 game with the shortest title
		 * 
		 */
		
		LinkedList<VideoGame> gamesList = new LinkedList<>(Arrays.asList(games));
		
		System.out.println(gamesList);
		
		VideoGame result = 
		gamesList.stream()
				 .map(game -> { game.title = game.title + "X"; return game; })
				 .filter(game -> game.lengthInHours % 2 == 0)
				 .filter(game -> game.numberOfPlayers < 4)
				 .reduce(null, (VideoGame a, VideoGame b) -> {
					 if (a != null && a.title.length() < b.title.length())
						 return a;
					 else return b;
				 });
		
		System.out.println(result);
		
	}

}

class VideoGame {
	
	String title;
	int numberOfPlayers;
	int lengthInHours;
	
	public VideoGame(String title, int numberOfPlayers, int lengthInHours) {
		super();
		this.title = title;
		this.numberOfPlayers = numberOfPlayers;
		this.lengthInHours = lengthInHours;
	}

	@Override
	public String toString() {
		return "VideoGame [title=" + title + ", numberOfPlayers=" + numberOfPlayers + ", lengthInHours=" + lengthInHours
				+ "]";
	}

}



