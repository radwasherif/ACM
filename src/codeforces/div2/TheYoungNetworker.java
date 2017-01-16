package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheYoungNetworker {
	
	static class Pair implements Comparable<Pair>
	{
		int num,idx;
		Pair(int a, int b)
		{
			num = a; idx = b;
		}
		
		public int compareTo(Pair p)
		{
			if(num!=p.num) return p.num - num;
			
			return idx-p.idx;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=  new Scanner(new FileReader("lan.in"));
		PrintWriter out = new PrintWriter(new FileWriter("lan.out"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Pair[] arr = new Pair[m];
		
		for(int i = 0; i < m; ++i) arr[i] = new Pair(sc.nextInt(),i);
		
		
		Arrays.sort(arr);
		
		int rem = n;
		boolean flag = false;
		boolean first = true;
		ArrayList<Integer>  l = new ArrayList<>();
		for(int i = 0; i<m; i++)
		{
			
			Pair cur = arr[i];
			if(rem<=0)
				break;
			if(i==0){
//				cur.num--;
				if(cur.num >= rem)
				{
//					System.out.println("hi");
					rem-=cur.num;
					l.add(cur.idx+1);
					break;
				}
				else
				{
					rem-=(cur.num-1);
					l.add(cur.idx+1);
				}
			}
			else
			{
				cur.num--;
				if(cur.num >= rem)
				{
					rem-=cur.num;
					l.add(cur.idx+1);
					break;
				}
				else
				{
					rem-=(cur.num-1);
					l.add(cur.idx+1);
				}
			}
		}
//		System.out.println(rem);
		if(rem>0)
			out.println("Epic fail");
		else
//			out.print(s);
		{
			out.println(l.size());
			int size = l.size();
			for(int i =0;i<size;i++){
				out.print(l.get(i));
				if(i!=size-1)
					out.print(" ");
			}
		}
		out.flush();
		out.close();
		
	}
	
	static class Scanner {
		BufferedReader br; 
		StringTokenizer st; 
		Scanner (InputStream s) {
			br = new BufferedReader(new InputStreamReader(s)); 
		}
		Scanner(FileReader r) {
			br = new BufferedReader(r); 
			
		}
		String next() throws IOException {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine()); 
			return st.nextToken(); 
		}
		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next()); 
		}
	}
}
