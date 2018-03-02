import java.util.Arrays;
import java.util.Scanner;

public class Assignment8 {
	static class Visit implements Comparable {
		int start, end; 
		Visit(int s, int e) {
			start = s; 
			end = e; 
		}
		@Override
		public int compareTo(Object o) {
			Visit v = (Visit) o; 
			return this.end - v.end; 
		}
		@Override
		public String toString() {
			return "starting at " + start + " ending at " + end; 
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt();
		Visit[] visits = new Visit[N]; 
		for(int i = 0; i < N; i++) {
			int start = sc.nextInt(); 
			int end = start + sc.nextInt();
			visits[i] = new Visit(start, end); 
		}
		Arrays.sort(visits);
		int assign[] = new int[N]; 
		int nextGuide = 0; 
		assign[0] = nextGuide++;  //assign the first guide to the first group
		System.out.println("Assign guide #" + (nextGuide - 1) + " to visit " + visits[0]);
		for(int i = 1; i < N; i++) {
			int free = -1; 
			//search for an earlier event that doesn't overlap with the current event
			//then its guide must be free and we can assign him/her to the current visit
			for(int j = i - 1; j >= 0; j--) {
				if(visits[j].end < visits[i].start) {
					free = assign[j];  
					break; 
				}
			}
			
			if(free != -1 ) {
				assign[i] = free;
				System.out.println("Assign guide #" + free + " to visit " + visits[i]);

			} else {
				assign[i] = nextGuide++; 
				System.out.println("Assign guide #" + (nextGuide - 1) + " to visit " + visits[i]);

			}
		}
	}
	
	/** 
	 * COMPLEXITY: complexity of sorting + complexity of searching previous visits * number of visits
	 * O(NlgN + N*N) = O(N*N) 
	 * 
	 * CORRECTNESS: 
	 * By following this algorithm, we guarantee that all events that do not overlap are assigned to the same guide, 
	 * which is the optimal solution for this problem, since a guide cannot be assigned to two visits at the same time.
	 * 
	 * First we sort the visits by end time, and then we assign a guide to the first visit. 
	 * For each visit, we would like to avoid assigning a new guide unless that is necessary, i.e. all previously assigned guides are 
	 * busy, so we search the list of all prior visits, if there is one of them that has ended, then we assign its guide to the current visit
	 * and so the total number of guides doesn't increase. 
	 * 
	 * **/
}
