package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CountingWeekendDays {
	static String days[] = { "", "SUN", "MON", "TUE", "WED", "THU", "FRI",
			"SAT" };
	static String month[] = { "", "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
			"JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	static int monLen[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static final int FRI = 6;
	static final int SAT = 7;
	static TreeMap<String, Integer> d;
	static TreeMap<String, Integer> m;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		d = new TreeMap<String, Integer>();
		m = new TreeMap<String, Integer>();
		for (int i = 1; i < days.length; i++) {
			d.put(days[i], i);
		}
		for (int i = 1; i < month.length; i++) {
			m.put(month[i], i);
		}
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int mon = m.get(st.nextToken());
			int day = d.get(st.nextToken());
			int start = FRI - day + 1;
			int ans = 0;
			if(day == SAT) {
				ans = 1; 
				start = 7; 
			}
			while (start <= monLen[mon]) {
				if (start <= monLen[mon])
					ans++;
				else break; 
				if (start + 1 <= monLen[mon])
					ans++;
				else break; 
				start += 7;
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}

}
