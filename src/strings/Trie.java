package strings;

public class Trie {
	
	static class Node {
		Node [] next = new Node[26]; 
		int count; 
	}
	Trie (String s) {
		for(int i = 0; i < s.length(); i++)
			put(s, i); 
	}
	Node root = new Node(); 
	void put(String s, int idx) {
		Node cur = root; 
		while(idx < s.length()){
			cur.count++; 
			Node nxt = cur.next[s.charAt(idx) - 'a']; 
			if(nxt == null)
				nxt = cur.next[s.charAt(idx) - 'a'] = new Node(); 
			cur = nxt; 
			idx++; 
		}
	}
	boolean search(String s) {
		Node cur = root; 
		for(int i = 0; i < s.length(); i++) {
			Node nxt = cur.next[s.charAt(i) - 'a']; 
			if(nxt == null)
				return false; 
			cur = nxt; 
		}
		return true; 
	}
	int findOcc(String s) {
		Node cur = root; 
		for(int i = 0; i < s.length(); i++) {
			Node nxt = cur.next[s.charAt(i) - 'a']; 
			if(nxt == null)
				return 0; 
			cur = nxt; 
		}
		return cur.count; 
	}
}
