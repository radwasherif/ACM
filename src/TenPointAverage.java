import java.util.Arrays;

public class TenPointAverage {
	public static void main(String[] args) {
		int a [] = {70, 50, 30, 40, 50, 60, 70, 80}; 
		int kernel[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int n = a.length;  
		int i = 0;
		int start;
		int end;
		int j;
		int avg;
		int res [] = new int [n]; 
		while( i < n) {
		    start = i - 4;
		    if(start < 0)
		      start = 0;
		    end = i + 5;
		    if(end >= n)
		      end = n - 1;
		    avg = 0;
		    j = start;
		    while( j<= end){
		      if(j >= 0 && j < n && (j-start) < 10 && (j - start) >= 0)
		      {
		        avg += kernel[j-start]*a[j];
		      }
		      j++;
		    }
		    res[i] = avg/(end - start + 1);
		    i++;
		 }
		System.out.println(Arrays.toString(res));
	}
}
