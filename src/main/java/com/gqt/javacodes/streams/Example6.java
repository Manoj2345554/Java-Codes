package com.gqt.javacodes.streams;

import java.util.ArrayList;

public class Example6 {
	public static void main(String[] args) {
		ArrayList<String> al =new ArrayList<String>();
		al.add("sachin");
		al.add("dhoni");
		al.add("virat");
		al.add("rohit"); 
		al.add("bumrah");
		
		System.out.println(al);
		System.out.println("=======================");
		long count=al.stream().filter(b->b.length()==5).count();
		System.out.println(count);
	}
	

}
