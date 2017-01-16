package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JapaneseCrossword {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char s[] = sc.next().toCharArray();
//		System.out.println(Arrays.toString(s));
		int blockCount = 0;
		int count = 0; 
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			
			if (s[i] == 'B')
			{
				count++;
//				System.out.println("YO");
			}
			else if (count > 0) {
				nums.add(count);
				count = 0;
				blockCount++;
			}
		}
		if(count > 0) {
			nums.add(count);
			count = 0;
			blockCount++;
		}
		System.out.println(blockCount);
		for (int i = 0; i < nums.size(); i++) {

			if (i > 0)
				System.out.print(" ");
			System.out.print(nums.get(i));

		}
		System.out.println();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));

		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
