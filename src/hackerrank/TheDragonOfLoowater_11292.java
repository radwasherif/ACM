package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class TheDragonOfLoowater_11292 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
//			System.out.println(m + " " + n);
			if (n == 0 && m == 0)
				break;

			
			
			int dragons [] = new int[n]; 
			ArrayList<Integer> kinghts = new ArrayList<Integer>();
			
			for (int i = 0; i < dragons.length; i++) {
				dragons[i] = sc.nextInt(); 
			}
			for (int i = 0; i < m; i++) {
				kinghts.add(sc.nextInt()); 
			}
			
			
			Arrays.sort(dragons);
			Collections.sort(kinghts);
			boolean possible = true; 
			int coins = 0; 
			for(int head: dragons) {
				if(kinghts.isEmpty()) {
					possible = false; 
					break; 
				}
				int index = Collections.binarySearch(kinghts, head); 
				if(index < 0) 
					index = -index - 1; 
				if(index >= kinghts.size()) {
					possible = false;
					break; 
				}
				coins += kinghts.get(index); 
				kinghts.remove(index); 
				
			}
			
			if(!possible) {
				out.println("Loowater is doomed!");
			} else {
				out.println(coins);
			}
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
	}
}
