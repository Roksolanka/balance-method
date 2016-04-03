package balanceMethod;

import java.util.Scanner;

public class MyExample {
	double A;
	double B;
	double kapa0;
	double d0;
	double kapaN;
	double dN;
	int n;
	public MyExample(int n)
	{
		this.n=n;
	}
	public void read(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A = ");
		A=sc.nextDouble();
		
		System.out.print("B = ");
		B=sc.nextDouble();
		
		System.out.print("kapa0 = ");
		kapa0=sc.nextDouble();
		
		System.out.print("\nd0 = ");
		d0=sc.nextDouble();
		
		System.out.print("\nkapaN = ");
		kapaN=sc.nextDouble();
		
		System.out.print("\ndN = ");
		dN=sc.nextDouble();
		sc.close();
		
	}
	public double getN() {
		return n;
	}
	public double getKapa0() {
		return kapa0;
	}
	public double getKapaN() {
		return kapaN;
	}
	public double getD0() {
		return d0;
	}
	public double getDN() {
		return dN;
	}
	public double k(double x) {
		return 2*Math.pow(x, 2)+1;
	}
	public double g(double x) {
		return 6*x;
	}
	public double f(double x) {
		return 10*Math.pow(x, 4)-40*Math.pow(x, 3)+10*x;
	}
	public double getA() {
		return A;
	}
	public double getB() {
		return B;
	}
}
