package DirectedGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class DirectedGraph<V, E> implements Graph {

	@Override
	public Vertex addVertex(Vertex v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected Map<V, Pair<Map<V,E>>> vertices;
	
	protected Map<E, Pair<V>> edges;
	
	public DirectedGraph() {
		vertices = new HashMap<V, Pair<Map<V,E>>>();
		edges = new HashMap<E, Pair<V>>();
	}
	
	@Override
	public boolean addEdge(E edge, Pair<? extends V> endpoints, EdgeType edgeType) {
		this.validateEdgeType(edgeType);
		Pair<V> new_endpoints = getValidatedEndpoints(edge, endpoints);
	}
	
		
}
