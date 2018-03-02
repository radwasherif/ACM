import java.util.ArrayList;
import java.util.Arrays;

public class AnalysisAssignment6 {
	static int N;
	static String s;
	static String[] L = { "ab", "ba", "abc" };;
	static int memo[];

	public static void main(String[] args) {

		s = "abbaac";
		N = s.length();
		Arrays.sort(L);
		memo = new int[N];
		Arrays.fill(memo, -1);
		int ans = dp(0);

		System.out.println((ans > 0) ? ans : "NO");
	}
	
	/**
	 * 
	 * 
	 * Assuming that is worst case both the substring function and compareTo have linear complexity O(m) 
	 * 
	 * Then the worst-case complexity is: 
	 *  O( |S| * ( |L| * (m + log|L| * m))) = O(|S| * |L| * log |L| * m )
	 * 
	 * 
	 */

	static int dp(int i) { // O( |S| * ( |L| * (m + log|L| * m))) 
		if (i == N)
			return 0;
		int ans = -10000000;
		if (memo[i] != -1)
			return memo[i];
		for (int j = i + 1; j <= N; j++) { //S

			String key = s.substring(i, j); //m
			if (search(key)) { //log|L|
				int tmp = 1 + dp(j);
				ans = Math.max(ans, tmp);
			}

		}
		return memo[i] = ans;
	}
	
	//log(|L|)
	static boolean search(String key) {
		// ArrayList<String> ans = new ArrayList<String>();
		int low = 0;
		int high = L.length - 1;
		// System.out.println(Arrays.toString(L));
		while (low <= high) {

			int mid = (low + high) / 2;
			// System.out.println(low + " " + high + " " + mid);
			int cmp = key.compareTo(L[mid]);
			// System.out.println(cmp);/
			if (key.equals(L[mid])) {
				return true;
			} else if (cmp > 0) {
				low = mid + 1;

			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
