package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	private ArrayList<Vertex> vertexes;
	private HashMap<Vertex, LinkedList<Vertex>> adjacencyList;
	
	public Graph(){
		
		this.vertexes = new ArrayList<Vertex>();
		//initialize adjacency list for vertex
		this.adjacencyList = new HashMap<Vertex, LinkedList<Vertex>>();
		
	}
	
	
	public void addVertex(Vertex vertex){
		this.vertexes.add(vertex);
		this.adjacencyList.put(vertex, new LinkedList<Vertex>());
	}
	
	
	public void addEdge(Vertex origin, Vertex destination) throws IndexOutOfBoundsException{
		
		ArrayList<Vertex> vertexes = this.vertexes;
		
		if (!vertexes.contains(origin) || !vertexes.contains(destination)){
			String error = "Not a valid vertex set\n";
			error += "origin: " + origin + "\ndestination: " + destination + "\n" + this.vertexes; 
			throw new IndexOutOfBoundsException(error);
		}
			
		//Put into adjacency list of vertex the new edge
		LinkedList<Vertex> originEdges = this.adjacencyList.get(origin);
		originEdges.add(destination);
		LinkedList<Vertex> destinationEdges = this.adjacencyList.get(destination);
		destinationEdges.add(origin);
		
	}
	
	
	/**
	 * Returns the number of disjoint sub graphs contained in a graph
	 * Uses BFT algorithm to account a connected graph given a vertex,
	 * the method does that for all non-visited vertexes.
	 * @return
	 */
	public int subGraphs(){
		
		int subGraphs = 0;
		Queue<Vertex> queue = new LinkedList<Vertex>();
		//Vertexes will be used as a sort of queue for all vertexes in graph
		ArrayList<Vertex> vertexes = this.vertexes;
		
		while (!vertexes.isEmpty()){
			
			//Apply BFS algorithm
			Vertex start = vertexes.remove(0);
			queue.add(start);
			start.visited = true;
			
			while(!queue.isEmpty()){
				
				Vertex source = queue.poll();
				
				for (Vertex v : this.adjacencyList.get(source)){
					if (v.visited == false){
						v.visited = true;
						queue.add(v);
						/*
						 * this vertex belongs to a subgraph
						 * it will not be accounted in the next iteration
						 */
						vertexes.remove(v);
					}
				}
			}
			
			//we finished with the last set of vertexes, this is a sub graph
			subGraphs++;
			
		}

		return subGraphs;
	}
	
	
	public String toString(){
		
		String str = "Graph " + this.adjacencyList + "\n";
		str += "Vertexes: " + this.vertexes + "\n";
		str += "Sub graphs: " + this.subGraphs();

		return str;
		
	}
	
	
	public void printReachable(Vertex v, int n){
		
		print(v);
		
		if (n == 0)
			return;

		for (Vertex a : this.adjacencyList.get(v)){
			//remove double links, will still appear repetitions of same vertex
			this.adjacencyList.get(a).remove(v);
			this.printReachable(a, n-1);
		}
		
	}
	
	
	public static void print(Object o){
		System.out.println(o);
	}
	
	
	public static void main(String args[]){
		
		//create vertexes
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		
		Graph graph = new Graph();
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		
		try{
			//3 disjoint graphs
			graph.addEdge(a, b);
			graph.addEdge(a, c);
			graph.addEdge(a, d);
			
			graph.addEdge(b, c);
			graph.addEdge(b, g);
			
			graph.addEdge(c, d);
			graph.addEdge(c, f);
			
			graph.addEdge(d, e);
			
			graph.addEdge(e, f);
			
			graph.addEdge(f, g);
	
		}catch(Exception exception){
			System.out.println(exception);
		}finally{
			print(graph);
			print("\nPrint Reachable vertexes\nLevel 0");
			graph.printReachable(a, 0);
			print("Level 1");
			graph.printReachable(a, 1);
			print("Level 2");
			graph.printReachable(a, 2);
		}
		
	}
	
	
}
