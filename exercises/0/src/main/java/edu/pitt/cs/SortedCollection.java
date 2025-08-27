package edu.pitt.cs;

import java.util.NoSuchElementException;
import java.util.ArrayList;

public class SortedCollection {
	ArrayList<Integer> collection = new ArrayList<>();
	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {

		if (collection.size() == 0) {
			collection.add(n);
		}

		else {
			boolean added = false;
			for (int i = 0; i < collection.size(); i++) {
				if (n > collection.get(i)) {
					collection.add(i, n);
					added = true;
					break;
				}
			}
			if (!added) {
				collection.add(n);
			}
		}
		
		
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		int size = collection.size();
		int removed;
		if (size == 0) {
			throw new NoSuchElementException("collection is empty");
		}
		
		else {
			removed = collection.remove(size-1);
		}

		return removed;
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		
		// If any commandline argument is not a number, call showUsage() and return.

		for (int i = 0; i < args.length; i++) {
			try {
				int num = Integer.parseInt(args[i]);
				collection.add(num);
			} catch (NumberFormatException e) {
				showUsage();
				return;
			}
		}
		
		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
