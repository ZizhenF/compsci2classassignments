public class Edge<N,W> implements IEdge<N,W> {
	INode<N> source;
	INode<N> dest;
	W weight;
	public Edge(INode<N> _source, INode<N> _dest, W _weight) {
		source = _source;
		dest = _dest;
		weight = _weight;
	}

	public INode<N> getSource() {
		return source;
	}

	public INode<N> getDestination() {
		return dest;
	}

	public W getWeight() {
		return weight;
	}

	/**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
	public boolean equals(Object o) {
		Edge<N,W> in = (Edge<N,W>) o;
		if (in.getSource() == source && in.getDestination() == dest) {
			return true;
		}
		else {
			return false;
		}
	}

	/*
	public static void main(String[] args) {
		INode<String> a = (INode<String>) new Node<String>("hahaha");
		INode<String> b = (INode<String>) new Node<String>("bibibi");
		IEdge<String,Integer> e1 = (IEdge<String,Integer>) new Edge<String,Integer>(a,b,1);
		IEdge<String,Integer> e2 = (IEdge<String,Integer>) new Edge<String,Integer>(a,b,2);
		System.out.println(e1.equals(e2));
	}
	*/
}