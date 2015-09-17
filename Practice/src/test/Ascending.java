package test;

import java.util.Scanner;

public class Ascending {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =4;
		int b =4;
		int c =4;
		
		if(a<=b&&b<=c&&a<=c){
			System.out.println("case1="+a+","+b+","+c);
		}
		else if(a<=b&&b>=c&&a<=c){
			System.out.println("case2="+a+","+c+","+b);
		}
		else if(b<=a&&a<=c&&b<=c){
			System.out.println("case3="+b+","+a+","+c);
		}
		else if(b<=a&&a>=c&&b<=c){
			System.out.println("case4="+b+","+c+","+a);
		}
		else if(c<=b&&b<=a&&c<=a){
			System.out.println("case5="+c+","+b+","+a);
		}
		else if(c<=a&&a<=b&&c<=a){
			System.out.println("case6="+c+","+a+","+b);
		}

	}

}
