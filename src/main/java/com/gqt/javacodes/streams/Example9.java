package com.gqt.javacodes.streams;

import java.util.ArrayList;
import java.util.Collections;

public class Example9 {
	public static void main(String[] args) {
		ArrayList<String> al =new ArrayList<String>();
		al.add("sachin");
		al.add("dhoni");
		al.add("virat");
		al.add("rohit"); 
		al.add("bumrah");
		
		System.out.println(al);
		System.out.println("=======================");
		Collections.sort(al);
		System.out.println(al);
	}
	

}
