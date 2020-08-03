package tw.com.bill.leecode.easy;

import java.util.HashMap;
import java.util.Stack;

public class VaildParentheses {
	private HashMap<Character, Character> ca;
	public VaildParentheses() {
		ca=new HashMap<Character, Character>();
		ca.put('(',')');
		ca.put('{','}');
		ca.put('[',']');
	}

	public static void main(String[] args) {
		String s="{[]}";
		VaildParentheses vp=new VaildParentheses();
		System.out.println(vp.isValid(s));
		
		

	}

	public boolean isValid(String s) {
		if(s.length()%2==1)return false;
		Stack<Character> a1=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(ca.containsKey(c)) {
				a1.push(ca.get(c));
				System.out.println(a1);
			}else if(ca.containsValue(c)) {
				if(a1.isEmpty()||a1.pop()!=c) {
					return false;
				}
			}
		}
		
		return a1.isEmpty();
	}
}
