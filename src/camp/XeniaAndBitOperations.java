package camp;

public class XeniaAndBitOperations {

	static class SegmentTree {
		int st[], array[]; 
		int N; 
		SegmentTree(int [] in) {
			N = in.length - 1; 
			st = new int[1 << N]; 
		}
		
		 void build() {
			build(1, 1, N); 
		}
		 void build(int ind, int left, int right) {
			 if(left == right)
			 {
				 st[ind] = array[ind];
				 return; 
			 }
		 }
		int left(int n) {
			return n*2; 
		}
		int right (int n) {
			return n*2 + 1; 
		}
	}
}
