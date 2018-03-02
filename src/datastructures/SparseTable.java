package datastructures;

public class SparseTable {
	int A[], SpT[][];

	public SparseTable(int A[]) {
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
		if(A[SpT[i][k]] < A[SpT[j - (1 << k) + 1][k]])
			return SpT[i][k]; 
		return SpT[j - (1 << k) + 1][k]; 
	}
}
