package com.gqt.javacodes.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example4 {
	public static void main(String[] args) {
		ArrayList<String> al =new ArrayList<String>();
		al.add("sachin");
		al.add("dhoni");
		al.add("virat");
		al.add("rohit"); 
		al.add("bumrah");
		
		System.out.println(al);
		System.out.println("=======================");
		List<String> res=al.stream().map(b->b.toUpperCase()).collect(Collectors.toList());
		System.out.println(res);
	}

}
