package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreetLamps {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); 
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine()); 
			int[] a = new int[n];
			String s = br.readLine(); 
			for (int i = 0; i < a.length; i++) {
				if (s.charAt(i) == '*') {
					a[i] = 1;
					if (i > 0)
						a[i - 1] = 1;
					if (i < n - 1)
						a[i + 1] = 1;
				}
			}
//			System.out.println(Arrays.toString(a));
			int count = 0;
			int ans = 0;
			for (int i = 0; i < a.length; i++) {
				if(a[i] == 0)
					count ++; 
				else {
//					System.out.println(count);
					ans += count(count); 
					count = 0; 
				}
			}
			if(count != 0)
				ans += count(count); 
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}

	static int count(int n ) {
		if(n == 0)
			return 0; 
		if(n <= 3)
			return 1; 
		int ans = n / 3; 
		if(n%3 != 0)
			ans++; 
		return ans; 
	}
	
}
