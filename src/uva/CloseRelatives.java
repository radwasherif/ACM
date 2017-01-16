package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * 11131 
 */
public class CloseRelatives {
	static ArrayList<Integer> graph[];
	static Stack <Integer> st1, st2; 
	static int counter; 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		String [] unmap = new String [5000+1]; 
		String line;
		counter = 1;
		StringTokenizer st;
		graph = new ArrayList[5000 + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		//int x = 2; 
		while (bf.ready()) {
			//while (x-- > 0) { 
			st = new StringTokenizer(bf.readLine(), ",");
			String parent = st.nextToken();
			//System.out.println(parent);
			if (!tm.containsKey(parent)) {
				tm.put(parent, counter);
			    unmap[counter++] = parent; 
			}

			while (st.hasMoreTokens()) {
				String child = st.nextToken();
				if (!tm.containsKey(child)) {
					tm.put(child, counter);
					unmap[counter++]  = child; 
				}	
				int i_parent = tm.get(parent);
				int i_child = tm.get(child);
				graph[i_parent].add(i_child);
				graph[i_child].add(i_parent);
			}
		}

		if (graph[1].size() == 1) {
			System.out.println(1 + "\n");
			st1 = new Stack<Integer>(); 
			dfs_r(1, -1);
			while (!st1.isEmpty()) {
				System.out.println(unmap[st1.pop()]);
			}
			
		} else {
			System.out.println(2 + "\n");
			st1 = new Stack<Integer>(); 
			st2 = new Stack<Integer>(); 
			dfs_r(1, -1);
			dfs_l(1, -1);
			while (!st1.isEmpty()) {
				System.out.println(unmap[st1.pop()]);
				
			}
			System.out.println();
			while (!st2.isEmpty()) {
				System.out.println(unmap[st2.pop()]);
			}
			//System.out.println();
		}

	}
	
	static void dfs_r (int u , int p) {
		st1.push(u);
		for (int v: graph[u] ) {
			if (v != p)
				dfs_r(v, u); 
		}
		 
	} 
	
	static void dfs_l(int u, int p) {
		int size = graph[u].size(); 
		st2.push(u); 
		for (int i = size -1; i >= 0; i--) {
			int v = graph[u].get(i); 
			if (v != p) {
				dfs_l(v, u); 
			}
		}
		
	}
} 
