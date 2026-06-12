package com.gqt.javacodes.streams;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
	public static void main(String[] args) {
		ArrayList<String> al =new ArrayList<String>();
		al.add("sachin");
		al.add("dhoni");
		al.add("virat");
		al.add("rohit");
		al.add("bumrah");
		
		System.out.println(al);
		System.out.println("=======================");
		ArrayList<String> res=new ArrayList<String>();
		for(int i=0;i<al.size();i++)
		{
			res.add(al.get(i).toUpperCase());
		}
		System.out.println(res);
	
	}

}
