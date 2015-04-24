
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
	
	//writes the result from ColorableGraph
	public static void writeGraph(ColorableGraph c, String filename){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("result_" + filename));
			writer.write(c.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//String filename = "cycle";
		//String filename = "largegraph1";
		//String filename = "largegraph2";
		String filename = "smallgraph.txt";

		Graph g = null;
		//creates graph with file
		try {
		    String str;
		    BufferedReader in = new BufferedReader(new FileReader(filename));
		   
		    //Initialize graph with the number of vertices
		    int size = Integer.valueOf(in.readLine());
		    g = new Graph(size);
		    
		    while ((str = in.readLine()) != null) {
		    	String[] values = str.split("\\s+"); 
		    	//adds an edge to the graph
		    	g.addEdge(Integer.valueOf(values[0])-1, Integer.valueOf(values[1])-1);
		    }
		    in.close();
		} catch (IOException e){ 
			
		}

		if (g == null){
			System.err.println("Graph Building Error");
		}
		
		ColorableGraph c = new ColorableGraph(g);
		//color graph in
		c.color();
		System.out.println(c);
		//writes output to file
		writeGraph(c,filename);
		
		
	}
	
}