package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class HelpingFillBates_UVa10567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		char s[] = sc.next().toCharArray();
		ArrayList<Integer> freq[] = new ArrayList[52];
		for (int i = 0; i < 52; i++)
			freq[i] = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			char c = s[i];
			if (c >= 'a' && c <= 'z')
				freq[c - 'a'].add(i);
			else
				freq[c - 'A' + 26].add(i);
		}
//		for (int i = 0; i < freq.length; i++) {
//			System.out.println(freq[i].toString());
//		}
		int q = sc.nextInt();
		while (q-- > 0) {
			char[] k = sc.next().toCharArray();
			boolean found = false;
			int start, end;
			start = end = 0;
			int largestIndex = -1;
			for (int i = 0; i < k.length; i++) {
				char c = k[i];
				int pos;
				ArrayList<Integer> arr; 
				if (c >= 'a' && c <= 'z') {
					arr = freq[c - 'a'];
				} else {
					arr = freq[c - 'A' + 26]; 
				}
				pos = binSearch(arr, largestIndex); 
//				System.out.println(c + " " + pos);
				if(pos < 0)
				{
					found = false; 
					break; 
				}
				if (i == 0)
					start = arr.get(pos);
				if (i == k.length - 1) {
					end = arr.get(pos);
					found = true;
					break;
				}
				largestIndex = arr.get(pos); 
			}
			if (found) {
				out.printf("Matched %d %d\n", start, end);
			} else {
				out.println("Not matched");
			}
		}
		out.close();
	}

	static int binSearch(ArrayList<Integer> a, int key) {
		int lo = 0;
		int hi = a.size() - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (a.get(mid) <= key)
				lo = mid + 1;
			else
				hi = mid;
		}
		if (a.get(lo) <= key)
			return -1;
		return lo;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
