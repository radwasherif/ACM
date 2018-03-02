package hackerrank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RansonNote {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); 
		int m = sc.nextInt(); 
		int n = sc.nextInt(); 
		HashMap<String, Integer> mag = new HashMap<String, Integer>(); 
		for(int i = 0; i < m; i++) {
			String s = sc.next();
			if(mag.containsKey(s)) {
				int val = mag.get(s); 
				mag.put(s, val + 1); 
			} else {
				mag.put(s, 1); 
			}
		}
		
		boolean can = true; 
		for(int i = 0; i < n; i++) {
			String s = sc.next(); 
//			System.out.println(s);
			if(mag.containsKey(s)) {
				
				int val = mag.get(s); 
				if(val > 0)
					mag.put(s, val - 1);
				else 
					can = false; 
			}
		}
		
		if(can) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
		sc.close();
		
	}
}
