package tw.com.bill.leecode.easy;


public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] str= {"flower","flow","flight"};
	    LongestCommonPrefix t1=new LongestCommonPrefix();
		System.out.println(t1.commonPrefix(str));

	}
	public String commonPrefix(String[] strs) {
		if(strs==null||strs.length==0) return "";
		String temp=strs[0];
		int i=1;
		while(i<strs.length) {
			while(strs[i].indexOf(temp)!=0)//index方法   返回指定字符在字符串中第一次出现處的索引，如果此字符串中没有這樣的字符，则返回 -1。
				temp=temp.substring(0,temp.length()-1);
				i++;
		}
		return temp;
	}
}
