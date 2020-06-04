package tw.bill.apps;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int d=scanner.nextInt();
		GuessNumber obj=new GuessNumber();
		String answer=obj.createAnswer(d);
		System.out.println(answer);
		
	}

	String createAnswer(int d) {
		int[] number=new int[d];
		
		for(int i=0;i<number.length;i++) {
			int random=(int)(Math.random()*9+1);
			number[i]=random;
		}
		
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<d;i++) {
			stringBuffer.append(number[i]);
		}
		
		
		
		return stringBuffer.toString();
	}
}
