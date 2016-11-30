package DirectedGraph;

public interface Graph<V> {

	public Vertex addVertex(Vertex v);
	
	protected Pair<V> getValidatedEndpoints(E edge, Pair<? extends V> endpoints) {
		
	}
	
}
