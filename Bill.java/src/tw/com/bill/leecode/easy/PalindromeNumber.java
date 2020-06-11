package tw.com.bill.leecode.easy;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int x=scanner.nextInt();
	PalindromeNumber number=new PalindromeNumber();
	System.out.println(number.isPalindrome(x));
	}
	public  boolean isPalindrome(int x) {
		int result=0;
		int origin=x;
		if(x<0) {
			return false;
		}else {	
				while(x!=0) {
					int pop=x%10;
					x/=10;
					if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return false;//判斷正數溢位問題
				    if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return false;//判斷負數溢位問題
				    result=result*10+pop;
				    
				}
		}

		return (result==origin);
	}
}
