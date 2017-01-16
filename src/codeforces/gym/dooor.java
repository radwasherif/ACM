package codeforces.gym;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dooor {
	static final int INF = (int)1e9;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  n  = sc.nextInt();
		String s = sc.next();
		int size =  s.length();
		LinkedList<Character> q = new LinkedList<>();
		for(int i =0 ; i < size; i++)
		{
			q.add(s.charAt(i));
		}
		int abs  = 0;int m = 0; int w = 0;
		while(!q.isEmpty()){
			char c1 = q.remove();
			char c2 = 'h';
			if(!q.isEmpty())
				c2 = q.remove();
			int abs1 = INF;
			int abs2 = INF;
//			int abs = INF;
			
			if(c1 == 'm')
			{
				abs1 = Math.abs((m+1) - w);
			}
			else
			{
				abs1 = Math.abs((w+1) - m);
			}
			
			if(c2 == 'm')
			{
				abs2 = Math.abs((m+1) - w);
			}
			else
			{
				if(c2=='w')
				abs2= Math.abs((w+1) - m);
			}
			abs = Math.min(abs1, abs2);
			System.out.println(abs);
//			if(abs==2)
//			{
//				System.out.println(m+" "+w);
//			}
			if(abs > n) break;
			
			if(abs1<abs2){
				if(c1 == 'm')
				{
//					abs1 = Math.abs((m+1) - w);
					m++;
				}
				else
				{
//					if(c1=='m')
//					abs1 = Math.abs((w+1) - m);
					w++;
				}
				
					
			}
			else
			{
				if(c2 == 'm')
				{
//					abs2 = Math.abs((m+1) - w);
					m++;
				}
				else
				{
					if(c2=='w')
//					abs2= Math.abs((w+1) - m);
					w++;
				}
				q.addFirst(c1);
			}
		}
		System.out.println(m+w);
	}
}
