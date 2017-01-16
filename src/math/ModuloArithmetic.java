package math;

public class ModuloArithmetic {
	static int mod; 
	public static void main(String[] args) {
		System.out.println(mod(-13, 64));
	}
	
	static int mod(int a, int n) {
		if (a >= 0)
			return a % n;
		return (a % n + n) % n;
	}
	static long mul(long a, long b) {
		return (a % mod * b % mod) % mod;
	}

	static long bigMod(long a, long e, int mod) {
		// System.out.println(a);
		a %= mod;
		long res = 1;
		while (e > 0) {
			if ((e & 1) == 1) {
				res = (res * a) % mod;
			}
			a =  (a * a) % mod;
			e >>= 1;
			//System.out.println(a);
		}
		return res;
	}

}
