package math;

public class GCDandLCM {
	static long lcm (int a, int b) {
		return (1l*a*b)/gcd(a,b); 
	}
	static long gcd(int n, int m) {
		if(m == 0)
			return n; 
		return gcd(m, n%m); 
	}
}
