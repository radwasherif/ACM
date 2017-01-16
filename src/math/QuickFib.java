package math;

import java.util.Arrays;

public class QuickFib {
	static int f[];

	public static void main(String[] args) {
		f = new int[100000+1];
		Arrays.fill(f, -1);
		System.out.println(fib(1000000000));
	}

	static int fib(int n) {
		if (n == 0)
			return  f[n] = 0;
		if (n <= 2)
			return f[n] = 1;
		if(n <= 100000 && f[n]!= -1)
			return f[n]; 
		int k = n >> 1;
		int a = fib(k), b = fib(k + 1);
		if (n % 2 == 0)
			return a * (2 * b - a);
		return b * b + a * a;
	}
}
