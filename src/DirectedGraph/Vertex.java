package DirectedGraph;

import java.util.Set;

public interface Vertex {
	
	public Set getPredecessors();
	
	public Set getSuccessors();
	
	public Set getInEdges();
	
	public Set getOutEdges();
	
	public int inDegree();
	
	public int outDegree();
	
	public int numPredecessors();
	
	public int numSucessors();
	
	public boolean isSucessorOf(Vertex v);
	
	public boolean isPredecessorOf(Vertex v);
	
	public boolean isSource(Edge e);
	
	public boolean isDest(Edge e);
	
	public Edge findEdge(Vertex v);
	
	public Set findEdgeSet(Vertex v);
	
}
