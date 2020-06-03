package tw.org.iii.java;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AddTwoNumbers {
	

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String x=scanner.next();
		String y=scanner.next();
		String z=scanner.next();
		String a=scanner.next();
		String b=scanner.next();
		String c=scanner.next();
		String result2=a+b+c;
		String result=x+y+z;
		int xyz=Integer.valueOf(result);
		int abc=Integer.valueOf(result2);
		System.out.println(xyz+abc);
	}
}
