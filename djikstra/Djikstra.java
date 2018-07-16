package djikstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex implements Comparable<Vertex> {

    public final String name;
    public List<Edge> adj = new ArrayList<>();
    public int min = Integer.MAX_VALUE;
    public Vertex previous;

    public Vertex(String name) { 
        this.name = name; 
    }
    
    public int compareTo(Vertex other){
        return Integer.compare(min, other.min);
    }  
}

class Edge {
	
    public final Vertex target;
    public final int weight;
    
    public Edge(Vertex target, int w) { 
    	this.target = target; 
    	this.weight = w; 
	}
}

public class Djikstra {
	
    public static void computePaths(Vertex src) {
        src.min = 0;
        
        Queue<Vertex> q = new LinkedList<Vertex>();
      	q.add(src);

	   while (!q.isEmpty()) {
	       Vertex u = q.poll();

            for (Edge e : u.adj){
                Vertex v = e.target;
                int weight = e.weight;
                int disToU = u.min + weight;
				if (disToU < v.min) {
				    q.remove(v);
				    v.min = disToU;
				    v.previous = u;
				    q.add(v);
				}
            }
        }
    }
    
    public static void addEdge(Vertex u, Vertex v, int w) {
    	
    	// undirected
    	u.adj.add(new Edge(v, w));
    	v.adj.add(new Edge(u, w));
    }

    /*    public static List<Vertex> getShortestPathTo(Vertex target){
    	
        List<Vertex> path = new ArrayList<Vertex>();

        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        
        return path;
    }*/

    public static void main(String[] args){
    	
    	// example...
    	
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");

        addEdge(v0, v1, 3);
        addEdge(v0, v3, 2);
        addEdge(v0, v4, 7);

        addEdge(v1, v0, 3);
        addEdge(v1, v2, 5);
        
        addEdge(v2, v1, 5);
        addEdge(v3, v0, 2);
        addEdge(v4, v0, 7);
        	
        // calc all paths to all nodes
        computePaths(v3);
        // print dis to get to v4 after prev. calc
        System.out.println(v4.min);       
    }
}