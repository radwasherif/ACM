package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * #355 - A
 *
 */
public class VanyaAndFence {
   public static void main(String[] args) throws IOException {
	   BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
	   StringTokenizer st = new StringTokenizer(bf.readLine()); 
	   int n = Integer.parseInt(st.nextToken()); 
	   int h = Integer.parseInt(st.nextToken()); 
	   int ans = 0; 
	   
	   st = new StringTokenizer(bf.readLine()); 
	   while (st.hasMoreTokens()) {
		   int height = Integer.parseInt(st.nextToken()); 
		   if (height > h ) {
			   ans += 2; 
		   } else { 
			   ans += 1; 
		   }
	   } 
	   
	   System.out.println(ans);
 	   
}
}
