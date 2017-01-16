package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuessYourWayOut {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int h = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int node = 1; 
		int result = 1; 
		int level = 1; 
		int path[] = new int[h];
		path[h - 1] = n;
		for (int i = h - 2; i >= 0; i--) {
			path[i] = path[i + 1] / 2;
		}
		while (node != n) {
		   //result +=  
		}
	} 
	
	public static int power (int base, int power) {
		int result = 1; 
		for (int i =0; i < power; i++) {
			result *= base; 
		} 
		return result; 
	}
}
