package tw.com.bill.leecode.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseInteger {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		System.out.println(reverse(x));
		

	}
	
	public static int reverse(int x) {
//		ArrayList<Integer> input=new ArrayList<>();//最初想法
//		int result;
//		int a=x/100;
//		int b=(x-a*100)/10;
//		int c=(x-a*100-b*10);
//		result=c*100+b*10+a;
		
//		return result;
		 int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            System.out.println("pop:"+pop);//取出的數字
	            x /= 10;
	            System.out.println("x:"+x);//x剩下的數字
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;//判斷正數溢位問題
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;//判斷負數溢位問題
	            rev = rev * 10 + pop;//rev負責進位
	            System.out.println("rev:"+rev);
	           
	        }
	        return rev;
		
	}
}
