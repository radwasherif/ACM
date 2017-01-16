package math;

public class Power {
	public static void main(String[] args) {
		System.out.println(bigMod(123456, 2, 1000));
	}

	static int pow(int a, int e) // O(log e)
	{
		int res = 1;
		while (e > 0) {
			if ((e & 1) == 1) {
				res *= a;

			}
			a *= a;
			e >>= 1;
		}
		return res;
	}

	static int bigMod(int a, int e, int mod) {
		a %= mod;
		int res = 1;
		while (e > 0) {
			if ((e & 1) == 1) {
				res = (res % mod * a % mod) % mod;
			}
			a = (a % mod * a % mod) % mod;
			e >>= 1;
		}
		return res;
	}
}
