package graphs;

public class Vertex {
	
	protected boolean visited;
	protected String label;
	
	public Vertex(String label){
		this.visited = false;
		this.label = label;
	}
	
	public String toString(){
		return this.label;
	}

}
