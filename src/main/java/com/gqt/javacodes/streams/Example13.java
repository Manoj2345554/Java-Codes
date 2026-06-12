package com.gqt.javacodes.streams;

import java.util.ArrayList;

public class Example13 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(100);
		al.add(125);
		al.add(75);
		al.add(25);
		al.add(125);
		al.add(175);
		System.out.println(al);
		System.out.println("---------------------");
		al.stream().forEach(i->System.out.println(i));
		System.out.println("---------------------");
		al.stream().forEach(System.out::println);
	}

}
