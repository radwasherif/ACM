package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CableWires {
	static BigInteger[] fib;

	public static void main(String[] args) throws NumberFormatException, IOException {
		fib(4000);
		int n;
		StringBuilder sb = new StringBuilder(); 

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		while(true) {
			n = Integer.parseInt(bf.readLine()); 
			if (n==0)
				break; 
			sb.append(fib[n*2]); 
			sb.append("\n"); 
			
		 } 
		System.out.print(sb.toString());
	}

	static void fib(int N) {
		fib = new BigInteger[N + 1];
		fib[0] = new BigInteger("0");
		fib[1] = new BigInteger("1");
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1].add(fib[i - 2]);
		}
	}
}
