package balanceMethod;

public class BalanceMethod { 
	double h;
	double[] x;
	MyExample ex;
	double[] a;//  above the main diagonal [1, n-1]
	double[] b;//  under the main diagonal [0, n-2]
	double[] c;// the main diagonal [0, n-1]
	double[] f;
	public BalanceMethod(MyExample ex)
	{
		this.ex = ex;
		h=Math.abs((double)(ex.getA()-ex.getB())/(double)ex.getN());
		x=new double[(int) (ex.getN()+1)];
		c=new double[(int) (ex.getN()+1)];
		a=new double[(int) (ex.getN()+1)];
		b=new double[(int) (ex.getN()+0)];
		f=new double[(int) (ex.getN()+1)];
	}
	private double a(int i){
		return (1/((double)(h* Math.pow(2, 0.5))))
				*(((1/(double)Math.tan(Math.pow(2*x[i], 0.5)))
						-(1/(double)Math.tan(Math.pow(2*x[i-1], 0.5)))));
		
	}
	private double d(int i) {
		return (6/(double)h)*(((Math.pow(x[i]+0.5*h, 2))/2.0)-((Math.pow(x[i]-0.5*h, 2))/2.0));
	}
	private double phi(int i) {
		return (1/(double)h)
				*((2*(Math.pow(x[i]+0.5*h, 5))-(Math.pow(x[i]-0.5*h, 5)))
						-(10*(Math.pow(x[i]+0.5*h, 4))-(Math.pow(x[i]-0.5*h, 4)))
						+(5*(Math.pow(x[i]+0.5*h, 2))-(Math.pow(x[i]-0.5*h, 2))));
	}
	public void fillMatrix()
	{
		int n=(int)ex.getN();
		//b[0]=a(1)/(double)h;
		//c[0]=-(a(1)/(double)h)-ex.getKapa0()-(h/2.0)*ex.getD0();
		b[0]=0;
		c[0]=1;
		for(int i=1; i<n; i++) {
			b[i]=a(i)/(double)Math.pow(h, 2);
			c[i]=-((a(i+1)+a(i))/(double)Math.pow(h, 2))-d(i);
			a[i]=a(i+1)/(double)Math.pow(h, 2);
		}
		//a[n]=a(n)/(double)h;
		//c[n]=-(a(n)/(double)h)-ex.getKapaN()-(h/2.0)*ex.getDN();
		a[n]=0;
		c[n]=1;
	}
	public void fillVector() {
		int n=(int)ex.getN();
		//f[0]=(ex.getD0()+(h/2.0)*phi(1));
		f[0]=phi(0);
		for(int i=1; i<n; i++) {
			f[i]=phi(i);
		}
		//f[n]=(ex.getDN()+(h/2.0)*phi(n));
		f[n]=phi(n);
	}
	public double[] formX() {
		for(int i=0; i<ex.getN()+1; i++) {
			x[i]=ex.A+i*h;
		}
		return x;
	}
	public void Solution() {
		x=formX();
		fillMatrix();
		fillVector();
		x=solveMatrix((int)(ex.getN()+1), a, c, b, f);
		for(int i=0; i< ex.getN()+1;i++) {
			System.out.print(Math.abs(x[i])-Math.abs(xExact(i)));
			//System.out.print(xExact(i));
			System.out.print("\n");
		}
	}
	public double xExact(int i) {
		return ((5/3.0)*Math.pow(x[i],3))+10/3.0;
	}
	public double[] solveMatrix (int n, double[] a, double[] c, double[] b, double[] f)
	{
		double[] x=new double [n];
		double m;
		for (int i = 1; i < n; i++)
		{
			m = a[i]/(double)c[i-1];
			c[i] = c[i] - m*b[i-1];
			f[i] = f[i] - m*f[i-1];
		}
		x[n-1] = f[n-1]/c[n-1];

		for (int i = n - 2; i >= 0; i--) {
			x[i]=(f[i]-b[i]*x[i+1])/c[i];
		}
		return x;
	}





}
