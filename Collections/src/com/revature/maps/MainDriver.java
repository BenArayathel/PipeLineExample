package com.revature.maps;

import java.util.HashMap;
import java.util.Map;

public class MainDriver {
	
	public static void main(String[] kiwis) {
		
/*
 * Map Interface
	
	Is an object that maps 'keys' to 'values' (also known as a dictionary in other languages). Each key has to be unique and can be mapped to only 
	one value, note that a key can be mapped to duplicate values. 

	Methods for basic operations:
		put, get, remove, containsKey, contiansValue, size and empty
	Bulk Operations:
		putAll, clear 
	Collection Views:
		keySet, entrySet and values.

	Classes:
		HashMap: (Uses a technique called "Hashing" to map large string to short string, helps in indexing and searching)
			Allows duplicate values, not duplicate keys 
			Allows a single null key and multiple null values
			Does not guarantee order (and unsynchronized compared to HashTable)

		TreeMap:
			Does not allow null keys, but does allow null values
			Sorted according to the natural ordering of the keys

		LinkedHashMap:
			Very similar to a HashMap, but it maintains insertion order 
	
You cannot iterate over the Map objects, like you would from the Collection interface:
	You will have to iterate over the key set (.keySet()), value set (.valueSet()) or the entry set (.entrySet()).
 */
		
		//We declare a map, "myMap", with the key being of type String and the value being of type String <"key","value">
		Map<String,String> myMap = new HashMap<>();
		
		//We use put instead of "add" from the Collection interface. 
		myMap.put("Apples", "A Red or Green thing");
		myMap.put("Earth", "A blue thing");
		myMap.put(null, "Filled with water");
		myMap.put("Grapes",null );
		
		//Map's also have their own toString() method
		System.out.println(myMap);
		
		//We use .get(), like List but we have to specify the key instead of index.
		System.out.println(myMap.get("Apples"));
		
		
		//We declare another Map, this time we use our own custom object instead of a standard Java class
		Map<Key,String> specialMap = new HashMap<>();
		
		Key myKey = new Key("Mercury");
		
		specialMap.put(myKey, "My key to Mercury");
				
		myKey = null;
		
		myKey = new Key("Mercury");
		
		//We have to have the original object, a new instance will not cut it. 
		System.out.println(specialMap.get(myKey));
		
		/*
		 * Why can we use new instances of Strings but not our own object? This is thanks to the String pool. 
		 * The String literals still exists inside the String pool, so the memory location is still preserved. Sometimes the GC might step in to remove it, but it will do so when 
		 * 	it is running out of memory capacity. 
		 */
		
		
		//We can grab the key, value and entry sets from out map. 
		System.out.println(myMap.keySet());
		System.out.println(myMap.values());
		System.out.println(myMap.entrySet());
		
		//The sets are collection objects, so we can iterate through them. 
		for(String s: myMap.keySet()) {
			System.out.println(myMap.get(s));
		}
//		
	}

}
