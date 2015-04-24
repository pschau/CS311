import java.util.ArrayList;
import java.util.List;

//creates an undirected graph G(V,E) and adjacency list for edges
public class Graph {
	//vertices & edges
	private int V,E;
	//adjacency lists
	 public ArrayList<Integer>[] adj;
	
	public int E() { 
		return E; 
		}
	
	public int V() { 
		return V; 
		}
	
	public void V(int V){
		this.V = V; 
		}
	
	
	//creates graph with V vertices
	@SuppressWarnings("unchecked")
	public Graph (int V){
		this.V = V;
		this.E = 0;
		this.adj = new ArrayList[V];
		//initialize adjacency list for each vertex to store adjacent vertices
		for (int i=0; i<V; i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	//list of adjacent vertices to u
	public List<Integer> adj(int u){
		return adj[u];
	}

	//adds edge and increases edge count
	public void addEdge(int u, int v){
		adj[u].add(v);
	    adj[v].add(u);
		E++;
	}
	

	
	
}