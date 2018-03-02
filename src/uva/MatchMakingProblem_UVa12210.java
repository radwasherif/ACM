package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class MatchMakingProblem_UVa12210 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		int t = 1;  
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			int[] bachelors = new int[n];
			ArrayList<Integer> spinsters = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				bachelors[i] = sc.nextInt();
			}
			
			for (int i = 0; i < m; i++) {
				spinsters.add(sc.nextInt());
			}
			
			Arrays.sort(bachelors);
			Collections.sort(spinsters);
			int bachelorsLeft = n; 
			for(int i = n - 1; i >= 0; i--) {
				if(spinsters.isEmpty())
					break; 
				int index = Collections.binarySearch(spinsters, bachelors[i]); 
				if(index < 0) {
					index = -index - 1; 
				}
				if(index == 0) {
					spinsters.remove(0); 
				} else if(index == spinsters.size()) {
					spinsters.remove(index - 1); 
				} else {
					int diffLeft = Math.abs(spinsters.get(index - 1) - bachelors[i]); 
					int diffRight = Math.abs(spinsters.get(index) - bachelors[i]); 
					if(diffLeft < diffRight) {
						spinsters.remove(index - 1); 
					} else {
						spinsters.remove(index); 
					}
				}
				bachelorsLeft--; 
				
			}
			String s = bachelorsLeft + ""; 
			if(bachelorsLeft > 0) {
				s += " " + bachelors[0]; 
			}
			out.println("Case " + t++ + ": " + s);
		} 
		out.flush();
		out.close(); 
		
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
