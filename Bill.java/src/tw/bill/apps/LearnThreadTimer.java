package tw.bill.apps;


import java.util.Timer;
import java.util.TimerTask;

public class LearnThreadTimer {

	public static void main(String[] args) {
		Timer timer=new Timer();
		MyTask1 myTask1=new MyTask1();
		EndTask endTask=new EndTask(timer);
		timer.schedule(endTask, 12*1000); //沒終止任務 下面那行會一直跑下去
		timer.schedule(myTask1, 0,500);
		
		

	}

}

class MyTask1 extends TimerTask{
	int i;
	@Override
	public void run() {
		System.out.println(i++);
		
	}
}

class EndTask extends TimerTask{
	Timer timer;
	EndTask(Timer timer) {this.timer=timer;}
	@Override
	public void run() {
		System.out.println("ok");
		timer.cancel();//取消任務
		timer.purge();//移除任務
		timer=null;
		
	}
}
