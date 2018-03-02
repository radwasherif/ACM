package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PayThePrice_UVa10313 {
	static long memo[][][]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		PrintWriter out = new PrintWriter(System.out);
		memo = new long[301][301][301]; 
		for(int i = 0; i < memo.length; i++) {
			for(int j = 0; j < memo[i].length; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
//		int c = 1; 
		while(br.ready()) {
//		while(c-- > 0 ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = 0, L1 = 0, L2 = 300; 
			int countTokens = st.countTokens(); 
			if(countTokens == 1) {
				N = Integer.parseInt(st.nextToken());
			} else if(countTokens == 2) {
				N = Integer.parseInt(st.nextToken());  
				L2 = Integer.parseInt(st.nextToken());
			} else {
				N = Integer.parseInt(st.nextToken()); 
				L1 = Integer.parseInt(st.nextToken());
				L2 = Integer.parseInt(st.nextToken()); 
			}
			if(L1 > 300)
				L1 = 300; 
			if(L2 > 300)
				L2 = 300; 
			
			long ans = 0; 
			for(int L = L1; L <= L2; L++) {
				
				ans += dp(L, 1, N); 
			}
			
			out.println(ans); 
		}
		out.flush();
	}
	
	static long dp(int count, int cur, int money) {
		if(count == 0 && money == 0)
			return 1; 
		if(count <= 0 || money < 0 || cur > 300)
			return 0; 
		if(memo[count][cur][money] != -1)
			return memo[count][cur][money]; 
		return memo[count][cur][money] = dp(count - 1, cur, money - cur) + dp(count, cur + 1, money); 
	}
}
