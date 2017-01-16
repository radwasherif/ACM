package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.InputMap;

public class Bees {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		fib(90);
		// System.out.println(fib[90] + " " + fibSum[90]);
		int n;
		while (true) {
			n = Integer.parseInt(bf.readLine());
			if (n == -1)
				break;
			System.out.println(fibSum2[n] + " " + fibSum[n]);

		}
	}

	static long fib[], fibSum[], fibSum2[];

	static void fib(int N) {
		fib = new long[N + 2];
		fibSum = new long[N + 1];
		fibSum2 = new long[N + 1];
		fib[0] = 0;
		fib[1] = 1;
		fibSum[0] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		for (int i = 1; i < fibSum.length; i++) {
			fibSum[i] += fibSum[i - 1] + fib[i + 1];
		}
		fibSum2[0] = 0;
		fibSum2[1] = 1;
		for (int i = 2; i < fibSum2.length; i++) {
			fibSum2[i] = fib[i] + fibSum2[i-1];   
		}
	}
}
