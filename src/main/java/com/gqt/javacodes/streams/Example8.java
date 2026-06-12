package com.gqt.javacodes.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example8 {
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
		List<Integer> res = al.stream().sorted().collect(Collectors.toList());
		System.out.println(res);
		
	}
	

}
