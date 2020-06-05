package tw.bill.apps;


import javax.swing.JOptionPane;

public class GuessNumber {
	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);
//		int d=scanner.nextInt();
		
		GuessNumber obj=new GuessNumber();
		String lengthing=JOptionPane.showInputDialog("決定數字長度:");
		int d=obj.inputNumber(lengthing);
		String answer=obj.createAnswer(d);
		System.out.println(answer);
		
		boolean isWinner=false;
		StringBuffer log=new StringBuffer();
		for(int i=0;i<10;i++){	
			String guess=JOptionPane.showInputDialog((i+1)+"輸入數字\n"+log.toString());
			
			if(!obj.checkGuess(guess,d))continue;
			
			
			String result=obj.checkAB(answer,guess);
			log.append(guess+"=>"+result+"\n");
			JOptionPane.showMessageDialog(null,result);
			
			if(result.equals(d+"A0B")) {
				isWinner=true;
				break;
			}
		
		}
		if(isWinner) {
			JOptionPane.showMessageDialog(null,"Winner");
		}else {
			JOptionPane.showMessageDialog(null,"Loser"+answer);
		}
	}
	
	boolean checkGuess(String g,int d) {
		boolean ret=false;
		if(g.matches("^[0-9]{"+d+"}$")) {
			boolean isDup=false;
			for (int i=0;i<d-1;i++) {
				char c=g.charAt(i);
				if(g.substring(i+1).indexOf(c)>=0) {
					isDup=true;
					break;
				}
			}
			ret=!isDup;
		}else {
			ret=false;
		}
		return ret;
	}
	
	
	int inputNumber(String len) {
		int i=Integer.valueOf(len);
		return i;
	}
	
	String checkAB(String a,String g) {
		int A,B;A=B=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)==g.charAt(i)) {
				A++;
			}else if(a.indexOf(g.charAt(i))!=-1) {
				B++;
			}
		}
		return A+"A"+B+"B";
	}

	String createAnswer(int d) {
		int[] number=new int[d];
		
		for(int i=0;i<number.length;i++) {
			int random=(int)(Math.random()*9+1);
			number[i]=random;
		}
		
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<d;i++) {
			stringBuffer.append(number[i]);
		}
		
		return stringBuffer.toString();
	}
}
