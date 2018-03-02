package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF551B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		int n = a.length();
		int counta[] = new int[26];
		int countb[] = new int[26];
		int countc[] = new int[26];
		for (int i = 0; i < a.length(); i++) {
			counta[a.charAt(i) - 'a']++;
		}

		for (int i = 0; i < b.length(); i++)
			countb[b.charAt(i) - 'a']++;

		for (int i = 0; i < c.length(); i++)
			countc[c.charAt(i) - 'a']++;

		 
		while(true) {
			int c1 = countMax(counta, countb); 
			int c2 = countMax(counta, countc); 
			if(c1 == 0 && c2 == 0) 
				break; 
			
			if(c1 > c2) {
				add(sb, b, counta); 
			} else {
				add(sb, c, counta); 
			}
			
		}
		
		for(int i = 0; i < 26; i++)
			while(counta[i]-- > 0)
				sb.append((char)(i + 'a')); 
		System.out.println(sb);
		
	
	}
	
	static void add(StringBuilder sb, String s, int [] count) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i); 
			sb.append(c); 
			count[c - 'a']--; 
		}
	}
	static int countMax(int a[], int b[]) {
		int min = 1000000000; 
		for(int i = 0; i < 26; i++) {
			if(b[i] != 0)
				min = Math.min(min, a[i]/b[i]); 
		}
		
		return min; 
	}
}
