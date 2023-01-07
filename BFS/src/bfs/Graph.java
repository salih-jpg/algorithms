package bfs;
import java.io.*;
import java.util.*;

public class Graph {
	public int vertex;
	public LinkedList<Integer> adj[];
	public Queue<Integer> queue;
	
	public Graph(int vertex) {
		this.vertex = vertex;
		adj = new LinkedList[vertex];
		for(int i = 0; i<vertex; i++) {
			adj[i] = new LinkedList<>();
		}
		queue = new LinkedList<Integer>();
	}
	
	public void addEdge(int v1, int v2) {
		adj[v1].add(v2);
	}
	
	public void BFS(int n) {
		boolean nodes[] = new boolean[vertex];
		int a  = 0;
		queue.add(n);
		int counter = 0;
		
		while(queue.size() != 0) {
			n = queue.poll();
			System.out.print(n +" ");
			
			for(int i = 0; i<adj[n].size(); i++) {
				counter++;
				a = adj[n].get(i);
				if(!nodes[a]) {
					nodes[a] = true;
					queue.add(a);
				}
			}
		}
		System.out.println("counter sum for proof of O(V+E): "+counter);
		
	}
	
	public static void main(String args[])
    {
        Graph graph = new Graph(6);
 
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
 
        System.out.println("The Breadth First Traversal of the graph is as follows :");
 
        graph.BFS(0);
    }
	
	
	
}
