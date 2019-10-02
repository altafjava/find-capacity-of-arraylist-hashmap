package com.altafjava.capacity.main;

import java.lang.reflect.Field;
import java.util.HashMap;

public class HashMapCapacity {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		HashMap<Integer, Integer> hm = new HashMap<>();

		System.out.println(getHashMapCapacity(hm));// 0 // its initial capacity is 0. When we insert any element then it increments its capacity with 16
		hm.put(1, 1);
		System.out.println(getHashMapCapacity(hm));// 16
		for (int i = 2; i <= 12; i++) // 12 is the load factor of 16 [16*0.75=12]
			hm.put(i, i);
		System.out.println(getHashMapCapacity(hm));// 16
		hm.put(13, 13);// When we insert 13th element then HashMap will increase its capacity by NC=(CC*2) | (16*2)=32
		System.out.println(getHashMapCapacity(hm));// 32
		for (int i = 14; i <= 24; i++) // 24 is the load factor of 32 [32*0.75=24]
			hm.put(i, i);
		System.out.println(getHashMapCapacity(hm));// 32
		hm.put(25, 25); // When we insert 25th element then HashMap will increase its capacity by (32*2)=64
		System.out.println(getHashMapCapacity(hm));// 64

	}

//HashMap initial Capacity = 0
//Incremental Size = 12 [16*0.75]
//0.75 is load factor When it reaches to more than 12. Means 13 then it increments by double of current capacity
//New Capacity=Current Capacity * 2 
//MAX CAPACITY = 1 << 30 = 1073741824 [2 to the power 30]

	public static int getHashMapCapacity(HashMap<Integer, Integer> hm) {
		Field field;
		int capacity = 0;
		try {
			field = HashMap.class.getDeclaredField("table");
			field.setAccessible(true);
			Object[] table = (Object[]) field.get(hm);
			capacity = table == null ? 0 : table.length;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return capacity;
	}
}
