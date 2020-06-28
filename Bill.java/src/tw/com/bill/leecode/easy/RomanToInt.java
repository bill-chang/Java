package tw.com.bill.leecode.easy;

import java.util.HashMap;

public class RomanToInt {
	public int romanToInt(String s) {
		if(s==null||s.length()==0) {return 0;}
		
		
		HashMap<Character, Integer> num=new HashMap<>();
		num.put('I', 1);
		num.put('V', 5);
		num.put('X', 10);
		num.put('L', 50);
		num.put('C', 100);
		num.put('D', 500);
		num.put('M', 1000);
		
		int sum=0;
	
		for(int i=0;i<s.length();i++) {
			if(i<=s.length()-2 && num.get(s.charAt(i))<num.get(s.charAt(i+1))) {
				sum-=num.get(s.charAt(i));
			}else {
				sum+=num.get(s.charAt(i));
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		String a="IIIIII";
		RomanToInt roman=new RomanToInt();
		System.out.println(roman.romanToInt(a));
	}

}
