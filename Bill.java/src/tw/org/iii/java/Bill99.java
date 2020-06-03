package tw.org.iii.java;

public class Bill99 {

	public static void main(String[] args) {
		int row=3;//代表橫向的ROW
		int start=1;//開頭
		int col=3;//一排有幾個
		
		for(int k=0;k<row;k++) {
			for(int j=1;j<10;j++) {
				for(int i=start;i<start+col;i++) {
					int newi=i+k*col;
					int result=newi*j;
					System.out.printf("%dx%d=%d\t",newi,j,result);
				}
				System.out.println();
			}
			System.out.println("================");
			
		}
		
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				int result=i*j;
				System.out.printf("%d*%d=%d\n",i,j,result);
			}
		}
	}

}
