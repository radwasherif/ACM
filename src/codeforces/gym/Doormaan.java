package codeforces.gym;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Doormaan {
	static final int INF = (int)1e9;
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		ArrayList<Character> arrList = new ArrayList<>();
		for(int i=0; i< s.length(); i++){
			arrList.add(s.charAt(i));
		}
		Queue<Integer> q  = new LinkedList<>();
//		q.
//		int res =0;
//		int size = 0;
		int size = s.length();
		int m = 0; int w = 0;
		for(int i = 0; !arrList.isEmpty(); ){
//			int cur = 
			char c1 = arrList.get(i);
			char c2 = arrList.get(i+1);
			int abs = INF;
			int abs1 = INF;
			int abs2 = INF;
			int nxt = -1;
			int nn = -1;
			if(c1 == 'm'){
				nxt = m+1;
				abs1 = Math.abs(nxt - w);
			}
			else{
				nxt = w+1;
				abs1 = Math.abs(nxt-m);
			}
			
			if(c2 == 'm'){
				nn = m+1;
				abs2 = Math.abs(nn-w);
			}
			else{
				nn = w+1;
				abs2 = Math.abs(nn-m);
			}
			abs = Math.min(abs1, abs2);
//			System.out.println(abs);
			if(abs1 < abs2){
				arrList.remove(i);
			}
			else
				if(arrList.size() > 1){
//					System.out.println(arrList.size());
//					System.out.println(i);
					arrList.remove(i);
				
				}
//			if()
//			if()
			if(abs > n)break;
//			m = nn;
			if(abs1<abs2){
				if(c1 == 'm'){
//					nxt = m+1;
					m = nxt;
//					abs1 = Math.abs(nxt - w);
				}
				else{
//					nxt = w+1;
					w = nxt;
//					abs1 = Math.abs(nxt-m);
				}
				
			}
			else
			{
				if(c2 == 'm'){
//					nn = m+1;
//					m = nn;
					m++;
//					abs2 = /Math.abs(nn-w);
				}
				else{
//					w = nn;
					w++;
					//					nn = w+1;
//					abs2 = Math.abs(nn-m);
				}
			}
//			else
				
			
		}
		System.out.println(m+w);
		
	}
}
