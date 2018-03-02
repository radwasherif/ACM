package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DecodeTheTape_UVa10878 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String s = 
				"o . \n" + 
				"ooo . o\n" + 
				"ooo .o o\n" + 
				"oo o. o\n" + 
				"oo . oo\n" + 
				"oo o. oo\n" + 
				"o . \n" + 
				"oo . o \n" + 
				"ooo . o \n" + 
				"oo o.ooo\n" + 
				"ooo .ooo\n" + 
				"oo o.oo\n" + 
				"o . \n" + 
				"oo .oo \n" + 
				"oo o.ooo\n" + 
				"oooo. \n" + 
				"o . \n" + 
				"oo o. o \n" + 
				"ooo .o o\n" + 
				"oo o.o o\n" + 
				"ooo . \n" + 
				"ooo . oo\n" + 
				"o . \n" + 
				"oo o.ooo\n" + 
				"ooo .oo \n" + 
				"oo .o o\n" + 
				"ooo . o \n" + 
				"o . \n" + 
				"ooo .o \n" + 
				"oo o. \n" + 
				"oo .o o\n" + 
				"o . \n" + 
				"oo o.o \n" + 
				"oo . o\n" + 
				"oooo. o \n" + 
				"oooo. o\n" + 
				"o . \n" + 
				"oo .o |\n" + 
				"oo o.ooo\n" + 
				"oo .ooo\n" + 
				"o o.oo \n" + 
				"o. o "; 
		
		String line = ""; 
		TreeMap<String, Character> tm = new TreeMap<> (); 
		StringTokenizer st = new StringTokenizer(s, "\n");
		
		tm.put("o . ", ' '); 
		while(st.hasMoreTokens()) {
			String t = st.nextToken(); 
			if(!t.equals("o . ")) {
				tm.put(t, )
			}
		}
		
		
	}
	static class Scanner {
		BufferedReader br; 
		StringTokenizer st; 
		
		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s)); 
		}
		
		String next() throws IOException {
			while(st == null || !st.hasMoreTokens())
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
