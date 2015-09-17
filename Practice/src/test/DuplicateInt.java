package test;

import java.util.HashSet;

public class DuplicateInt {
	public static void main(String args[]){
		int a = 2555;
		String temp = ""+a;
		System.out.println(temp);
		String t[] = temp.split("");
		int i = t.length-1;
		System.out.println(i);
		HashSet<String> h = new HashSet<String>();
		HashSet<String> u = new HashSet<String>();
		
		for(String s: t){
			if(!h.add(s))
				i--;
			else
				u.add(s);
			
		}
		System.out.println(u);
	}

}
