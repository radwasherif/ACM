import java.util.Arrays;
import java.util.Scanner;

public class AnalysisAssignment5 {
	static int a[][];
//	static int p[][];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		a = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int ans = getMax();
		int ans2 = -1000000000;
		for (int i = 0; i < n; i++) {
			ans2 = Math.max(ans2, dp(n - 1, i));
		}
		System.out.println(ans);
		System.out.println(ans2);
	}

	static int getMax() {
		int ans = -1000000000;
		int starti = 0, startj = 0;
		int sol[][] = new int[a.length][a.length];
		for (int j = 0; j < a.length; j++) {
			sol[0][j] = a[0][j];
		}

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				int add = sol[i - 1][j];
				if (j - 1 >= 0)
					add = Math.max(add, sol[i - 1][j - 1]);
				if (j + 1 < a.length)
					add = Math.max(add, sol[i - 1][j + 1]);

				sol[i][j] = a[i][j] + add;

				if (i == a.length - 1) {
					if (ans < sol[i][j]) {
						ans = sol[i][j];
						starti = i;
						startj = j;
					}
				}
			}
		}

		int i = starti;
		int j = startj;
		System.out.printf("%d, %d\n", starti, startj);
		while (i > 0) {
			if(sol[i][j] - a[i][j] == sol[i - 1][j]) {
				System.out.printf("%d, %d\n", i - 1, j);
			}
			if( j > 0 && sol[i][j] - a[i][j] == sol[i - 1][j - 1])
			{
				System.out.printf("%d, %d\n", i - 1, j - 1);
				j--; 
			}
			if(j < n - 1 && sol[i][j] - a[i][j] == sol[i - 1][j + 1])
			{
				System.out.printf("%d, %d\n", i - 1, j + 1);
				j++; 
			}
			
			i--; 
		}

		return ans;
	}

	static int dp(int i, int j) {
		if (j < 0 || j >= n)
			return -1000000;
		if (i == 0)
			return a[i][j];
		int up = a[i][j] + dp(i - 1, j);
		int right = a[i][j] + dp(i - 1, j + 1);
		int left = a[i][j] + dp(i - 1, j - 1);

		return Math.max(up, Math.max(left, right));
	}
}
