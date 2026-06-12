package com.gqt.javacodes.streams;

import java.util.ArrayList;

public class Example11 {
	public static void main(String[] args) {
		ArrayList<String> al =new ArrayList<String>();
		al.add("sachin");
		al.add("dhoni");
		al.add("virat");
		al.add("rohit"); 
		al.add("bumrah");
		
		System.out.println(al);
		System.out.println("=======================");
		String min=al.stream().min((s1,s2)->s1.compareTo(s2)).get();
		System.out.println("the min valued string is : "+min);
		System.out.println(" ----------------");
		String max=al.stream().max((s1,s2)->s1.compareTo(s2)).get();
		System.out.println("the max valued string is : "+max);
		System.out.println(" ----------------");
	}

}
