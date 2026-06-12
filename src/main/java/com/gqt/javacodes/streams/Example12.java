package com.gqt.javacodes.streams;

import java.util.ArrayList;

public class Example12 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("sachin");
		al.add("dhoni");
		al.add("virat");
		al.add("rohit");
		al.add("bumrah");

		System.out.println(al);
		System.out.println("=======================");
		al.stream().forEach(i -> System.out.println(i));
		System.out.println("--------------");
		al.stream().forEach(System.out::println);

	}

}
