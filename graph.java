import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private static LinkedList<Integer> queue = new LinkedList<Integer>();
	private static boolean[] visited = new boolean[100];
	
	
private static void addEdge(ArrayList<ArrayList<Integer>> adj , int u , int v) {
	adj.get(u).add(v);
	adj.get(v).add(u);
}

private static void testGraphFunc(ArrayList<ArrayList<Integer>> adj , int v) {
	queue.add(v);
	visited[v] = true;
	while(queue.size() !=0) {
		int vertex = queue.poll();
		System.out.print(vertex + " -> ");
		ArrayList<Integer> l = adj.get(vertex);
		Iterator<Integer> itr = l.iterator();
		while(itr.hasNext()) {
			int vx = itr.next();
			if(visited[vx] == false) {
				queue.add(vx);visited[vx] = true;
			}
		}
	}
	
}

private void bfs(ArrayList<ArrayList<Integer>> adj , int start) {
	testGraphFunc(adj, start);
}
	
private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
	for ( int i = 0 ; i < adj.size() ; ++i) {
		System.out.print(i + "-> ");
		for (int j = 0 ; j < adj.get(i).size();j++) {
			System.out.print(adj.get(i).get(j)+" -> ");
			
		}
		System.out.println();
	}
}



public static void main(String[] args) {
	int V = 6; 
	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
	
	for ( int i = 0 ; i < V; i++) 
		adj.add(new ArrayList<Integer>());
	 addEdge(adj, 0, 1);
     addEdge(adj, 0 , 2);
     addEdge(adj, 1, 2);
     addEdge(adj, 2 , 3);
     addEdge(adj , 3, 4);
     addEdge(adj, 0 , 5);
	printGraph(adj);
	System.out.println("=====================");
	testGraphFunc(adj, 4);

}
}
