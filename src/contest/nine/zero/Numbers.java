package contest.nine.zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numbers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine()); 
		int sum = 0;
		int den = n-2; 
		for (int i = 2; i < n; i++) {
			sum += addDigits(n, i); 
		}
		int gcd = gcd(sum, den);
		//System.out.println(gcd);
		sum /= gcd; 
		den /= gcd; 
		System.out.println(sum + "/" + den);
	}
	static int addDigits(int n, int base) {
		int ans = 0; 
		while (n > 0) {
			ans += n%base; 
			n /=base; 
		}
		return ans; 
		
	}
	static int gcd (int x, int y) {
		if (x== y) return x; 
		if(x > y) {
			return gcd (x-y, y); 
		} 
		else {
			return gcd(x, y-x); 
		}
	}
}

