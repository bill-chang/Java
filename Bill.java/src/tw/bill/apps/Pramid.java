package tw.bill.apps;

public class Pramid {

	public static void main(String[] args) {
		printArrow(5);
		
	}
	public static void printArrow(int n) {
		for(int i=1;i<=n;i++) {// 負責印/n
			for(int b=1;b<=n-i;b++) {//  負責印空白
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {// 負責印*
				if(j%2==1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
		for(int i=1;i<=n;i++) {// 負責印/n
			for(int b=1;b<=i;b++) { //負責印空白
				System.out.print(" ");
			}
			for(int j=1;j<=2*(n-i)-1;j++) { //負責印*
				if(j%2==1) {
					System.out.print("*"); //記得後面要用print
				}else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

}
