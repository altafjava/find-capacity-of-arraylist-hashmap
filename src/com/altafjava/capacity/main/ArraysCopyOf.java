package com.altafjava.capacity.main;

import java.util.Arrays;

public class ArraysCopyOf {
	public static void main(String[] args) {
		
		Object[] arr={5,8,9};
		System.out.print("Original Array : ");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
		arr=Arrays.copyOf(arr, 5);
		System.out.print("Copied Array : ");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
