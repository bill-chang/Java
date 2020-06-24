package tw.bill.apps;

public class LearnThread {

	public static void main(String[] args) {
		Thread1 t1=new Thread1("a");
		Thread1 t2=new Thread1("b");
		MyThreadRunnable my123=new MyThreadRunnable("bill");
		Thread t3=new Thread(my123);
		t1.start();
		t2.start();
		t3.start();

	}
	

}

class Thread1 extends Thread{
	private String name;
	public Thread1(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		super.run();
		for(int i=0;i<30;i++) {
			System.out.println(name+":"+i);
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				
			}
		}
	}
}

 class MyThreadRunnable implements Runnable{//runnable 用實作的方式 可以使用原先類別的方法 也可繼承別的類別 算是適性比較好的方法 對比 extends thread來說
	 private String name;
	 public MyThreadRunnable(String name) {
		this.name=name;
	}
	 @Override
	public void run() {
		for(int i=0;i<30;i++) {
			System.out.println(name+":"+i);
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		 
	}
 }
