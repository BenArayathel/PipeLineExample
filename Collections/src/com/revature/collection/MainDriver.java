package com.revature.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class MainDriver {
	
	public static void main(String[] apples) {
		
		/*
		 * Why?
		Array object within Java is limited to work with. Mainly the array is immutable. I could create my own custom version of an array, 
		but it'll likely be poorly optimised and it'll be difficult to share the data structure between developers. This is where the 
		Collection Framework comes in:

	Called a framework (more akin to a library). Provides interfaces and classes that allow deveopers to more easily manage groups of objects.
	A 'collection' object is designed to stored to a group of objects. It gives you more flexibilities.

	Advantages:
		Reduces effort (provides data structures and algorithms for you)
		Increases performance (creates fine-tuned implementations of data structure and algorithms)
		Encourages software reuse (provides a standard interface)

	BUT!
		Does not allow primitive data types, need to use Wrapper classes to convert into objects. 
		int -> Integer
		boolean -> Boolean
		byte -> Byte
		The process of converting a primitive data types into its Wrapper class is called boxing(autoboxing).
		From Wrapper Class to primitive -> unboxing
		 */
		
		String[] arrayString ;//declaration
		
		arrayString = new String[3];
		
		arrayString[0] = "Hi there!";
		
		int[][][][][] arrayInt = new int[3][3][10][3][3]; 
		
		arrayInt[0][0][0][0][1] = 1;
		
//		System.out.print(arrayString[0]);
		
		arrayString = new String[10];
		
//		for(String x: arrayString) {
//			System.out.println(x);
//		}
		
		for(int[][][][] x: arrayInt) {
			for(int[][][] y: x) {
				for(int[][] z : y) {
					
				}
			}
		}
		
		
		
		//With Arrays you have to iterate throught the list manualy and print out each element 
		//Arrays can't be resized. 
		
		
	//------------------------GENERICS-----------------------------------------------------------
		//This is straight from documentation : https://docs.oracle.com/javase/tutorial/java/generics/why.html
		/*
		 * In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods. 
		 * Much like the more familiar formal parameters used in method declarations, type parameters provide a way for you to re-use the same code with different inputs. 
		 * The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types.
		 * 
		 * <>
		 */
		
		
	//------------------------COLLECTIONS---------------------------------------------------------
		
		
		
		/*
		 * ----------------------------------------------------LIST----------------------------------------------------
			An ordered collection. 
			May contain duplicate elements.
			Access via index (positional access) : interact with elements based on their numerical position in the list. 
								(get, set, add, addAll and remove)
			Search : find a specified object in the list and return its position. (indexOf and lastIndexOf)
			Iteration : extends 'Iterator' to utilise the list's sequential nature
			Range-view : Perform arbitary range operations (sublist)

			Lists have to contain the same elements in the same position to be equal

			Classes:
				ArrayList:
					A resizable array (mutable) compared to the built in array inside Java. Allows you to add and remove 
					elements. (syntax is different to array)
				LinkedList:
					Consists of nodes, each node will store a value and a 'pointer' to the next node. Allows for easier 
					addition and removal for entries (ArrayLists have to resize the entire structure). However requires more
					memory overhead, each node holds the data plus addresses to other nodes.
				Vector:
					Depcreated (contains legacy methods), but is synchronised
		 */
		
		
		List<String> stringList = new ArrayList<>(); //We're missing the size, we don't need it because it can change if we choose it to be
		stringList.add("Hi There");
		stringList.add("Hi There"); //Allows duplicates 
		stringList.add("the end");
		stringList.add("goodbye!");
		stringList.add(2, "number 21");//WE can specify a particular position, it moves the over values up a position.
		
		stringList.listIterator();
		
		List<String> otherList = new LinkedList<>(); //Can be implemented based on other child classes. 
		
		otherList.add("Apples");
		otherList.add("Kiwi");
		otherList.add("Banana");
		
		
//		Collection<String> lisst = new ArrayList<>(); //Any interface can be instantiated by any of its child classes. 
//		
//		lisst.list
		
//		System.out.println(stringList);
//		System.out.println(otherList.get(2));
		
		
		/*
		 * ----------------------------------------------------SET----------------------------------------------------
			Do not allow duplicates
			Do not guarantee insertion order
			(Only inherits methods from the Collection + restriction to duplicate)
			Sets are equal if they contain the same elements. 

			Classes:
				HashSet : (Maintains no order, stores in hash table, best performance)
				LinkedHashSet (Maintains insertion order, linked list running through it, weaker performance) 
				TreeSet (Maintains value order, red-black tree, very slow)
				
				HashSet vs TreeSet:
					HashSet allows null values and hetrogenous objects, TreeSet does not because of compareTo() method.
		 */
		
		Set<Double> mySet = new HashSet<>();
		
		mySet.add(100.0);
		mySet.add(200.0);
		mySet.add(300.0);
		mySet.add(400.0);
		mySet.add(250.0);
//		System.out.println(mySet.add(100.0));
//		System.out.println(mySet.add(500.0));
		
//		for(Double num: mySet) {
//			System.out.println(num);
//			/*
//			 * if(num == mynum){
//			 * syso(num);
//			 */
//		}
		
		Set<Double> myTreeSet = new TreeSet<>();
		
		myTreeSet.addAll(mySet);
		
		mySet.add(null);
		
		
		Set<String> myLinkedSet = new LinkedHashSet<>();
		myLinkedSet.add("DragonFruit");
		myLinkedSet.add("Watermelon");
		myLinkedSet.add("Coconut");
		
//		System.out.println(myLinkedSet);
//		
//		
//		System.out.println(myTreeSet);

		
		
		/*
		 * ----------------------------------------------------Queue----------------------------------------------------
			Ordered list of objects related to insertion order.
			Follows the FIFO (First-In-First-Out) principle. 
			Methods:
				poll,remove,peek and element

			Classes:
				LinkedList: 
					Same as List, consists of Nodes, can be used to implement Queues. 
				PriorityQueue:
					Doesn't permit null
					Can't store hetrogenous objects
					Unbounded queues.
				ArrayDeque:
					Similar to LinkedList, faster performance. Does not allow null values though. 
					Allows concurrent operations as well
		 */
		
		Queue<String> myQueue = new LinkedList<>();
		
		myQueue.add("Mercury");
		myQueue.add("Venus");
		myQueue.add("Earth");
		myQueue.add("Earth");
		myQueue.add(null);
		
		
		
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.peek());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
		
		Queue<String> myDequeQueue = new ArrayDeque<>();
		
		
		myDequeQueue.add("Jupiter");
		myDequeQueue.add("Neptune");
		myDequeQueue.add("Mars");
		myDequeQueue.add("Mars");
//		myDequeQueue.add(null);
		
//		for(String s: myQueue) {
//			myQueue.poll();
//			System.out.println(s);
//		}
//		
		for(String s: myDequeQueue) {
			myDequeQueue.poll(); 
			System.out.println(s);
		}
		
//		Queue<String> myPriority = new PriorityQueue<>();
//		
//		
//		myPriority.addAll(myQueue);
//		myPriority.addAll(myDequeQueue);
//		myPriority.addAll(myLinkedSet);
//		
//		System.out.println(myPriority);
		
		
		
		
		
		
	}

}
