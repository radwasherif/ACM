package hackerrank;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class LarrysArray {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in); 
		int t = sc.nextInt();
		while (t-- > 0) {
			int inversionIndex = 0;
			int n = sc.nextInt();
		 
			int a[] = new int[n];
			
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}
			for (int k = 0; k < a.length; k++) {
				for (int j = k + 1; j < a.length; j++) {
					if (a[j] < a[k])
						inversionIndex++;
				}
			}
			if (inversionIndex % 2 == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
