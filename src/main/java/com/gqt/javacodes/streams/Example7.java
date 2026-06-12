package com.gqt.javacodes.streams;

import java.util.ArrayList;
import java.util.Collections;

public class Example7 {
	public static void main(String[] args) {
		ArrayList<Integer> al =new ArrayList<Integer>();
		al.add(100);
		al.add(50);
		al.add(150);
		al.add(25);
		al.add(75);
		al.add(456);
		System.out.println(al);
		System.out.println("-----------------");
		Collections.sort(al);
		System.out.println(al);
		
	}
	

}
