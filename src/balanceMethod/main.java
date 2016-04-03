package balanceMethod;

import java.util.Scanner;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Balance Method \n Please input: \n n = ");
		int n=sc.nextInt();
		
		MyExample example=new MyExample(n);
		
		example.read();
		BalanceMethod bm=new BalanceMethod(example);
		bm.Solution();
		sc.close();
	}

}
