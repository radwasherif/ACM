package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.text.Highlighter;

public class GoUpTheUltras_UVa12674 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = 2;
		while (c-- > 0) {
			// while (sc.ready()) {
			int n = sc.nextInt();
			int A[] = new int[n];
			for (int i = 0; i < n; i++)
				A[i] = sc.nextInt();

			int count = 0;

			int hiLeft[] = new int[n]; // index of the first element to the left of A[i] larger than A[i]
			int hiRight[] = new int[n]; // index of the first element to the right of A[i] larger than A[i]
			hiLeft[0] = -1;
			for (int i = 1; i < n; i++) {
				hiLeft[i] = i - 1;
				while (hiLeft[i] != -1)
					if (A[hiLeft[i]] > A[i])
						break;
					else
						hiLeft[i] = hiLeft[hiLeft[i]];
			}

			hiRight[n - 1] = n;
			for (int i = n - 2; i >= 0; i--) {
				hiRight[i] = i + 1;
				while (hiRight[i] != n)
					if (A[hiRight[i]] > A[i])
						break;
					else
						hiRight[i] = hiRight[hiRight[i]];
			}

			SparseTableMin sp = new SparseTableMin(A);
			for (int i = 1; i < n; i++) {
				int d = A[i];
				if(hiLeft[i] != -1)
					d = Math.min(d, sp.query(hiLeft[i], i - 1));
				if(hiRight[i] != n)
					d = Math.min(d, sp.query(i + 1, hiRight[i])); 
				
				if(A[i] - d >= 150000) {
					if(count++ > 0)
						out.print(" ");
					out.print(i + 1);
				}
				
				
			}
			out.println();

		}
		out.flush();
		out.close();
	}

	static class SparseTableMin {
		int A[], SpT[][];

		public SparseTableMin(int A[]) {
			this.A = A;
			int n = A.length;
			int k = (int) Math.floor((Math.log(n) / Math.log(2))) + 1;
			SpT = new int[n][k];
			for (int i = 0; i < n; i++)
				SpT[i][0] = i;

			for (int j = 1; (1 << j) <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++) {
					if (A[SpT[i][j - 1]] < A[SpT[i + (1 << (j - 1))][j - 1]])
						SpT[i][j] = SpT[i][j - 1];
					else
						SpT[i][j] = SpT[i + (1 << (j - 1))][j - 1];
				}

		}

		int query(int i, int j) {
			int k = (int) Math.floor((Math.log(j - i + 1) / Math.log(2)));
			if (A[SpT[i][k]] < A[SpT[j - (1 << k) + 1][k]])
				return SpT[i][k];
			return SpT[j - (1 << k) + 1][k];
		}
	}

	static class SparseTableMax {
		int A[], SpT[][];

		public SparseTableMax(int A[]) {
			this.A = A;
			int n = A.length;
			int k = (int) Math.floor((Math.log(n) / Math.log(2))) + 1;
			SpT = new int[n][k];
			for (int i = 0; i < n; i++)
				SpT[i][0] = i;

			for (int j = 1; (1 << j) <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++) {
					if (A[SpT[i][j - 1]] > A[SpT[i + (1 << (j - 1))][j - 1]])
						SpT[i][j] = SpT[i][j - 1];
					else
						SpT[i][j] = SpT[i + (1 << (j - 1))][j - 1];
				}

		}

		int query(int i, int j) {
			int k = (int) Math.floor((Math.log(j - i + 1) / Math.log(2)));
			if (A[SpT[i][k]] > A[SpT[j - (1 << k) + 1][k]])
				return SpT[i][k];
			return SpT[j - (1 << k) + 1][k];
		}
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

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}

}
