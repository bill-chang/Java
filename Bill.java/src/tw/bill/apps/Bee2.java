package tw.bill.apps;


public class Bee2 {

	public static void main(String[] args) {
		int n=8;
		Bee2.ppp(n);
		
	}
	
	public static void ppp(int n) {
		int ans=0;
		int female=0;
		int male=0;
		if(n==0) {
			System.out.println("0");
		}else {
			for(int i=1;i<=n;i++) {
				male=female+1;
				female=ans;
				ans=female+male;
				System.out.println("公蜂數量:"+female+"總數:"+ans);
			}
		}
	}
}
