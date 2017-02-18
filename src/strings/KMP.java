package strings;

public class KMP {
	public static void main(String[] args) {

	}

	// O(n)
	static int[] prefixFunction(char s[]) {
		int n = s.length;
		int pi[] = new int[n];
		// j is the last pi and the first index after the prefix we're matching
		// the character we should be checking
		for (int i = 1, j = 0; i < n; i++) {
			while (j > 0 && s[i] != s[j]) {
				j = pi[j - 1];
			}
			if (s[i] == s[j])
				j++;
			pi[i] = j;
		}

		return pi;
	}

	static int[] countPrefixOcc(int pi[]) {
		int ans[] = new int[pi.length];
		for (int i = 0; i < ans.length; i++) {
			ans[pi[i]]++;
		}
		for (int len = pi.length - 1; len > 0; len--) {
			ans[pi[len - 1]] += ans[len];
			for (int i = 0; i < ans.length; i++) {
				ans[i]++;
			}
		}
		return ans; 
	}
}
