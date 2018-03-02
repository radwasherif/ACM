package hackerrank; 

import java.util.Scanner;




public  class Contacts {
	
	public  static void main (String args []) {
		Scanner sc = new Scanner(System.in); 
		int  n = sc.nextInt(); 
		Trie t = new Trie(); 
		while(n-- > 0) {
			String s = sc.next(); 
			if(s.equals("add")) {
				t.put(sc.next(), 0); 
            } else {
               int occ = t.findOcc(sc.next()); 
               System.out.println(occ);
            }
        }
		
		
    }
	
	 static class Trie {
		
		Node root = new Node(); 
		
		void put(String s, int idx) {
			Node cur = root; 
			root.count++; 
			while(idx < s.length()) {
				Node nxt = cur.next[s.charAt(idx) - 'a']; 
				if(nxt == null)
					nxt = cur.next[s.charAt(idx) - 'a'] = new Node(); 
				nxt.count++; 
				cur = nxt; 
				idx++; 
			}
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

        static class Node {
            Node [] next = new Node[26]; //26 english alphabets 
            int  count; //number of strings that reach this node
        }



} 


