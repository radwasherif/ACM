package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solitaire {
	static String a[][]; 
	static int n, m; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> cards = new ArrayList<>();
		TreeMap<String, Integer> tm = new TreeMap<>();
		int count = 0;
		String[] suits = { "C", "H", "S", "D" };
		for (int i = 0; i < suits.length; i++) {
			for (int rank = 2; rank <= 9; rank++) {
				cards.add(rank + suits[i]);
				tm.put(rank + suits[i], count++);
			}
			cards.add("T" + suits[i]);
			tm.put("T" + suits[i], count++);
			cards.add("J" + suits[i]);
			tm.put("J" + suits[i], count++);
			cards.add("Q" + suits[i]);
			tm.put("Q" + suits[i], count++);
			cards.add("K" + suits[i]);
			tm.put("K" + suits[i], count++);
			cards.add("A" + suits[i]);
			tm.put("A" + suits[i], count++);
		}
		boolean taken[] = new boolean[cards.size()];
		int x[] = new int[2];
		int y[] = new int[2];
		Arrays.fill(x, -1);
		Arrays.fill(y, -1);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new String[n][m];
		int I = 0; 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.next();

				if (a[i][j].equals("J1")) {
					x[I++] = i;
					y[I++] = j;
				} else if (a[i][j].equals("J2")) {
					x[I++] = i;
					y[I++] = j;
				} else {
					taken[tm.get(a[i][j])] = true;
				}
			}
		}
		int r1, c1, r2, c2;
		r1 = c1 = r2 = c2 = -1; 
		if(x[0] == -1 && y[0] == -1) {
			System.out.println("Solution exists.");
			System.out.println("There are no jokers.");
		} else {
			for(int i = 0; i < cards.size(); i++) {
				if(taken[i])
					continue; 
				a[x[0]][y[0]] = cards.get(i); 
				if(x[1] != -1 && y[1] != -1) 
					for(int j = 0; j < cards.size(); j++) {
						if(j == i || taken[j])
							continue; 
						a[x[1]][y[1]] = cards.get(j); 
					}
				
				int check [] = check(); 
			}
		}

	}
	static int [] check () {
		int ans [] = new int[4];
		Arrays.fill(ans, -1);
		for(int i = 0; i < n - 2; i++) {
			for(int j = 0; j < m - 2; j++) {
				char suit = a[i][j].charAt(1);
				boolean sameSuit = true; 
				for(int i1 = 0; i1 < 3; i1++) {
					for(int j1 = 0; j1 < 3; j1++) {
						if(a[i + i1][j + j1].charAt(1) != suit)
						{
							sameSuit = false; 
							break; 
						}
					}
					if(!sameSuit)
						break; 
				}
				if(!sameSuit)
					continue; 
				ans[0] = i; 
				ans[1] = j; 
				for(int k = 0; k < n - 2; k++) {
					for(int l = 0; l < m - 2; l++) {
						TreeSet<Character> ranks = new TreeSet<>(); 
						for(int k1 = 0; k1 < 3; k1++) {
							for(int l1 = 0; l1 < 3; l1++) {
								if(k1 >= i && k1 <= i + 3 && l1 >= j && l1 <= j + 3) 
									continue; 
								ranks.add(a[k + k1][l + l1].charAt(0)); 
							}
						}
						if(ranks.size() == 9)
						{
							ans[2] = k; 
							ans[3] = l; 
						}
					}
				}
			}
		}
		return ans; 
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

	}
}
