package math;

public class Catalan {
	static long cat []; 
   public static void main(String[] args) {
	   cat(1000); 
	   System.out.println(cat[4]);
	
} 
   
   static void cat(int N) {
	   cat = new long[N+1]; 
	   cat[0] = 1; 
	   for (int i = 1; i < cat.length; i++) {
		cat[i] = 2*i *(2*i-1)*cat[i-1]/(i*(i+1)); 
	}
   }
}
