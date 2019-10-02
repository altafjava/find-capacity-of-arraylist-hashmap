package com.altafjava.capacity.main;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListCapacity {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ArrayList<Integer> al = new ArrayList<>();
		System.out.println(getArrayListapacity(al));// 0 // Its initial Capacity is 0 but when we insert any data into arraylist then it creates 10 empty buckets
		al.add(1);
		System.out.println(getArrayListapacity(al));// 10
		for (int i = 2; i <= 10; i++)
			al.add(i);
		System.out.println(getArrayListapacity(al));// 10
		al.add(11);// When its capacity is full then it increases it capacity by New Capacity=(CC*3/2) | NC=(10*3/2)=15
		System.out.println(getArrayListapacity(al));// 15
		for (int i = 12; i <= 15; i++)
			al.add(i);
		System.out.println(getArrayListapacity(al));// 15
		al.add(16);// When its capacity is full then it increases it capacity by NC=(15*3/2)=22
		System.out.println(getArrayListapacity(al));// 22
	}

//	Internally ArrayList uses this method to increase its capacity elementData = Arrays.copyOf(elementData, newCapacity);
	public static int getArrayListapacity(ArrayList<Integer> al) {
		Field field;
		int capacity = 0;
		try {
			field = ArrayList.class.getDeclaredField("elementData");
			field.setAccessible(true);
			Object[] table = (Object[]) field.get(al);
			capacity = table == null ? 0 : table.length;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return capacity;
	}
}
