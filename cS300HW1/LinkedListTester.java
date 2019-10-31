package cS300HW1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LinkedListTester {
	
	private static MyLinkedList myList;
	private static MyLinkedList myList2;
	private static ArrayList<Object> collection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myList = new MyLinkedList();
		myList2 = new MyLinkedList();
		collection = new ArrayList<Object>();
		collection.add("cherry");
		collection.add("banana");
		collection.add("apple");
		collection.add("dog");
		collection.add("cat");
		Scanner sc = new Scanner(System.in);
		int n = 0;
		myList.reset();
		myList2.addFirst("apple");
		myList2.addFirst("apple");
		myList2.addFirst("banana");
		myList2.addFirst("banana");
		myList2.addFirst("orange");
		myList2.addFirst("orange");
		
		while (n != 24) {
			System.out.println("\nPress keys for example" + "\n1). Add" + "\n2). Add at index" + 
			"\n3). Add all without index" + "\n4). Add all with index" + "\n5). Add first" +
			"\n6). Add last" + "\n7). Clear" + "\n8). Contains" + "\n9). Contains All" + "\n10). Equals" +
			"\n11). Get" + "\n12). Index of" + "\n13). Is empty" + "\n14). Iterator" +
			"\n15). Last index of" + "\n16). Remove at index" + "\n17). Remove" + "\n18). Remove all" +
			"\n19). Retain all" + "\n20). Set at index" + "\n21). Size" + "\n22). List" +
			"\n23). String" + "\n24). Close the program\n");
			try {
				n = sc.nextInt();
			}
			catch (Exception e) {
				 System.out.println("Not an integer, crashing down");
				 n = 24;
			}
			
			if (n == 1) {//add
				System.out.println("List before add:\n" + myList + "\n");
				myList.add("orange");
				System.out.println("List after add:\n" + myList);
				myList.reset();
			}
		
			if (n == 2) {//add at index
				System.out.println("List before add:\n" + myList);
				System.out.println("Index of add: 1\n");
				myList.add(1 , "orange");
				System.out.println("List after add:\n" + myList);
				myList.reset();
			}
		
			if (n == 3) {//add all w/o index
				System.out.println("List before add:\n" + myList + "\nData to add:\n" + collection);
				myList.addAll(collection);
				System.out.println("List after add:\n" + myList);
				myList.reset();
			}
		
			if (n == 4) {//add all w/ index
				System.out.println("List before add:\n" + myList + "\nData to add:\n" + collection);
				System.out.println("Index of add: 1\n");
				myList.addAll(1, collection);
				System.out.println("List after add:\n" + myList);
				myList.reset();
			}
		
			if (n == 5) {//add first
				System.out.println("List before adding first:\n" + myList + "\n");
				myList.addFirst("orange");
				System.out.println("List after adding first:\n" + myList);
				myList.reset();
			}
		
			if (n == 6) {//add last
				System.out.println("List before adding last:\n" + myList + "\n");
				myList.addLast("orange");
				System.out.println("List after adding last:\n" + myList);
				myList.reset();
			}
		
			if (n == 7) {//clear
				System.out.println("List before clear:\n" + myList + "\n");
				myList.clear();
				System.out.println("List after clear:\n" + myList);
				myList.reset();
			}
		
			if (n == 8) {//contains
				System.out.println("Checking if this list contains 'apple':\n" + myList + "\n");
				System.out.println("Does this list contain 'apple'?\n" + myList.contains("apple"));
			}
		
			if (n == 9) {//contains All
				System.out.println("Does list:\n" + myList +"\n" + "Contain:\n" + collection + "\n");
				System.out.println("The answer is: " + myList.containsAll(collection));
			}
		
			if (n == 10) {//equals
				System.out.println("List1:\n" + myList + "\nList2:\n" + myList2 + '\n');
				System.out.println("Are these lists equal?:\n" + myList.equals(myList2));
			}
			
			if (n == 11) {//get
				System.out.println("List:\n" + myList + "\nIndex to get: 1\n");
				System.out.println("Data got:\n" + myList.get(1));
			}
		
			if (n == 12) {//index of
				System.out.println("List:\n" + myList + "\nData to get index of: banana\n");
				System.out.println("Index is " + myList.indexOf("banana"));
			}
		
			if (n == 13) {//is empty
				System.out.println("Checking if this list is empty:\n" + myList + "\n");
				System.out.println("Is the list empty?\n" + myList.isEmpty());
			}
		
			if (n == 14) {//iterator
				Iterator<Object> itr = myList.Iterator();
				System.out.println("List before:\n" + myList + "\nNext node returns:\n" );
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			}
		
			if (n == 15) {//last index of
				System.out.println("Checking what is the last index of 'banana':\n" + myList2 + "\n");
				System.out.println("The last index is: " + myList2.lastIndexOf("banana"));
			}
		
			if (n == 16) {//remove at index
				System.out.println("Removing at index 1 from this list:\n" + myList);
				System.out.println("Data removed:\n" + myList.remove(1));
				myList.reset();
			}
		
			if (n == 17) {//remove
				System.out.println("Before removing 'apple' from this list:\n" + myList + "\n");
				myList.remove("apple");
				System.out.println("After removing 'apple':\n" + myList);
				myList.reset();
			}
		
			if (n == 18) {//remove all
				System.out.println("List before remove:\n" + myList + "\nData to remove:\n" + collection + "\n");
				myList.removeAll(collection);
				System.out.println("Data after remove:\n" + myList);
				myList.reset();
			}
		
			if (n == 19) {//retain all
				System.out.println("List before retain all:\n" + myList + "\nData to retain:\n" + collection + "\n");
				myList.retainAll(collection);
				System.out.println("Data after retain all:\n" + myList);
				myList.reset();
			}
		
			if (n == 20) {//set
				System.out.println("List before set:\n" + myList + "\nData to set: 'balloon' at index 2\n");
				myList.set(2, "balloon");
				System.out.println("List after set:\n" + myList);
				myList.reset();
			}
			
			if (n == 21) {//size
				System.out.println("List:\n" + myList + "\nSize:\n" + myList.size());
			}
		
			if (n == 22) {//list
				System.out.println("List from 0-2:\n" + myList + "\nIndex range we want: 1-3\n");
				System.out.println("List after range change:\n" + myList.subList(1, 3));
			}
		
			if (n == 23) {//string
				System.out.println("Printing myList:\n" + myList.toString());
			}
			
			else if (n < 0 || n > 24) {
				System.out.println("Please enter a valid number");
			}
		}
		System.out.println("Closing");
		sc.close();
		System.out.close();
	}
}
/*throw UnsupportedOperationException();
throw ClassCastException();
throw NullPointerException();
throw IllegalArgumentException();
throw IndexOutOfBoundsException();*/