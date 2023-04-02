package dfs;
import java.io.*;
import java.util.*;

public class Dfs {
	private int V;
	private LinkedList<Integer>adj[];
	
	@SuppressWarnings("unchecked") Dfs(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i< v; i++) {
			adj[i] = new LinkedList();
		}
		
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void DFSutil(int v, boolean visited[]) {
		
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> i = adj[v].listIterator();
	      while (i.hasNext()) {
	    	  int n = i.next();
	          if (!visited[n])
	              DFSutil(n, visited);
	        }
	}
	
	void DFS(int s) {
		boolean visited[] = new boolean[V];
		DFSutil(s, visited);
	}
	
	
	public static void main(String args[])
    {
        Dfs g = new Dfs(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Following is Depth First Traversal "+ "(starting from vertex 2)");
        g.DFS(2);
    }
}
