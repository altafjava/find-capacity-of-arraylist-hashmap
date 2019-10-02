package com.altafjava.capacity.main;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class HashtableCapacity {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		System.out.println(getHashtableCapacity(ht));
		ht.put(1, 1);
		System.out.println(getHashtableCapacity(ht));
		for (int i = 2; i <= 8; i++) // 8 is the load factor of 11 [11*0.75=8.25]
			ht.put(i, i);
		System.out.println(getHashtableCapacity(ht));
		ht.put(9, 9); // When we insert 9th element then hashtable will increase its capacity by NC=(CC*2)+1 | (11*2)+1=23
		System.out.println(getHashtableCapacity(ht));
		for (int i = 10; i <= 17; i++) // 17 is load factor of 23 [23*0.75=17.25]
			ht.put(i, i);
		System.out.println(getHashtableCapacity(ht));
		ht.put(18, 18);// When we insert 18th element then hashtable will increase its capacity by (23*2)+1=47
		System.out.println(getHashtableCapacity(ht));
	}

//Hashtable initial Size=11
//Incremental Size = 8 [11*0.75=8.25]
//0.75 is load factor. When it cross its load factor means when we insert more than 8 then its capacity increases by double of current size and plus 1
//New Capacity=(Current Capacity * 2) + 1 
//NC=(11*2)+1=23
//NC=(23*2)+1=47

	public static int getHashtableCapacity(Hashtable<Integer, Integer> ht) {
		Field field;
		int capacity = 0;
		try {
			field = Hashtable.class.getDeclaredField("table");
			field.setAccessible(true);
			Object[] table = (Object[]) field.get(ht);
			capacity = table == null ? 0 : table.length;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return capacity;
	}
}
