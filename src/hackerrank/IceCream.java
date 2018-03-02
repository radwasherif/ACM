package hackerrank;

import java.util.*;

public class IceCream implements Comparable {
	int index;
	int cost;

	IceCream(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	public int compareTo(Object o) {
		IceCream c = (IceCream) o;
		return this.cost - c.cost;
	}

	public boolean equals(Object o) {
		IceCream c = (IceCream) o;
		return c.index == this.index;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			IceCream a[] = new IceCream[n];
			for (int i = 1; i <= n; i++) {
				int x = sc.nextInt();
				a[i - 1] = new IceCream(i, x);
			}
			Arrays.sort(a);
//			for(int i = 0; i < a.length; i++) {
//				System.out.printf("(%d, %d) ", a[i].index, a[i].cost); 
//			}
			for (int i = 0; i < n - 1; i++) {
				int find = m - a[i].cost;
				IceCream c = binarySearch(find, a, i + 1);
				if (c != null) {
					System.out.println(Math.min(a[i].index, c.index) + " " + Math.max(a[i].index, c.index));
					break;
				}
			}
		}
	}

	public static IceCream binarySearch(int find, IceCream[] a, int start) {
		int high = a.length - 1;
		int low = start;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid].cost == find)
				return a[mid];
			if (a[mid].cost < find)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return null;

	}

}
