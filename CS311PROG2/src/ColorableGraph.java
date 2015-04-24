import java.util.LinkedList;
import java.util.Stack;

public class ColorableGraph {
	private boolean colorable = true;
	// list of visited nodes
	private boolean[] visited;
	//list of color a vertex
	private boolean[] color;
	// list of visited nodes' parent
	private Integer[] parent;
	private Stack<Integer> cycle;
	private Graph G;
	
	//initialize graph and lists
	public ColorableGraph(Graph G){
		this.visited = new boolean[G.V()];   
		this.color = new boolean[G.V()];
		this.parent = new Integer[G.V()];   	     
		this.G = G;
		
		//initialize lists for visited, color and parent
		for (int i=0; i<G.V(); i++){
			visited[i] = false;
			color[i] = false;
			parent[i] = null;
		}
	}
	
	//dfs for each unvisited vertex v adjacent to u and colors as needed
	public void dfs(Graph G, int u){
		//adds vertex to visited
		visited[u] = true;
		//returns if colorable is false
		if (!colorable) return; 
		
		//visit adjacent vertices
		for(int v : G.adj(u)){
			//returns if colorable is false
			if (!colorable) return;
			
			if (!visited[v]){
				//remembers parent of v
				parent[v] = u;
				//mark v as visited
				visited[v] = true;
				//update v to the opposite color of parent
				color[v] = !color[u];
				//dfs with v as parent
				dfs(G, v);
			}
			
			//if u and v are same color, cycle
			if(color[u] == color[v]){
				colorable = false;
				//creates cycle using stack
			    cycle = new Stack<Integer>();
                cycle.push(u);
                for (int x = v; x != u && parent[x]!=null; x = parent[x]) {
                    cycle.push(x);
                }
                //connects to the initial starting point of cycle
                cycle.push(u);
				return;
			}
		}
	}
	
    public Iterable<Integer> cycle() { return cycle;       }
	
	//performs dfs to color graph
	public void color(){
		for (int i=0; i<G.V(); i++){
			if (!visited[i] || i==0){
				dfs(G, i);
			}
		}
	}
	
	
	//output if graph is 2-colorable
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append(String.format("%s\n", colorable ? "Yes":"No"));

		//graph is colorable
		if (colorable){
			//outputs the results of the colorable graph
			for (int i=0; i<G.V(); i++){
				output.append(String.format("%s, %s\n", i+1, getColor(color[i])));
			}
		} 
		
		//graph is not colorable
		else {
			// output cycle
			for(Integer n : cycle()){
				output.append(String.format("%s,%s\n", n+1, getColor(color[n])));
			}
		}
		return output.toString();
	}
	
	//returns a color for true/false
	private String getColor(boolean color){
		return color ? "B" : "R";
	}
	
}

