package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TheNewRuleInEuphomia_UVa10742 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static int primeCount;
	static int[][] dp;
	static int x, y;
	static int n;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime(1000000);
		int t = 1;
		// System.out.println(primes.size() * primes.size());
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			long ans = 0;
			for (int i = 0; i < primes.size(); i++) {
				int p = primes.get(i);
				if (p > n)
					break;
				System.out.println(binarySearch(p));
				ans += binarySearch(p);
			}
			// System.out.println(count);
			sb.append("Case " + t++ + ": " + ans/2);
			sb.append('\n');

		}

		System.out.print(sb);
	}

	static int binarySearch(int p) {
		int ans = 0;
		int lo = 0;
		int hi = primes.size() - 1;
		while (hi > lo) {
			int mid = (hi + lo) / 2;
			if (primes.get(mid) <= n - p) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}
		if (p <= primes.get(ans))
			return ans;
		else
			return ans + 1;

	}

	static void prime(int n) {
		boolean[] prime = new boolean[n + 1];
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				primes.add(i);
				for (int j = 2; i * j <= n; j++) {
					prime[i * j] = false;
				}
			}
		}
	}
}
