package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A391 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		String s = bf.readLine(); 
		int one [] = new int[5]; 
		int two [] = new int[2]; 
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i); 
			if(c == 'B')
				one[0]++; 
			if(c == 'l')
				one[1]++; 
			if(c == 's')
				one[2]++; 
			if(c == 'r')
				one[3]++; 
			if(c == 'b')
				one[4]++; 
			
			if(c == 'u')
				two[0]++; 
			if(c == 'a')
				two[1]++; 
		
		}
		int min = 1000000000; 
		for (int i = 0; i < two.length; i++) {
			two[i]/=2;
			min = Math.min(min, two[i]); 
		}
		for (int i = 0; i < one.length; i++) {
			min = Math.min(one[i], min); 
		}
		System.out.println(min);
	}
}
