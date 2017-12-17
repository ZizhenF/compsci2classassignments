public class Graph<N,W> implements IGraph<N,W> {
	ArrayList<INode<N>> nodes;
	ArrayList<IEdge<N,W>> edges;

	public Graph() {
		nodes = new ArrayList<INode<N>>();
		edges = new ArrayList<IEdge<N,W>>();
	}

	public INode<N>[] getNodeSet() {
		Object[] oa = nodes.getarray();
		INode<N>[] set = (INode<N>[])new INode[oa.length];
		for(int i=0;i<oa.length;i++) { set[i]=(INode<N>)oa[i]; }
		return set;
	}

	public INode<N>[] getNeighbors(INode<N> n) {
		ArrayList<INode<N>> neighbors = new ArrayList<INode<N>>();
		for (int i=0; i<edges.size(); i++) {
			if ((edges.fetch(i)).getSource()==n) {
				neighbors.append((edges.fetch(i)).getDestination());
			}
			else if ((edges.fetch(i)).getDestination()==n) {
				neighbors.append((edges.fetch(i)).getSource());
			}
		}
		Object[] oa = neighbors.getarray();
		INode<N>[] set = (INode<N>[])new INode[oa.length];
		for(int i=0;i<oa.length;i++) { set[i]=(INode<N>)oa[i]; }
		return set;
	}

	 public INode<N> addNode(N v) {
	 	INode<N> n = (INode<N>) new Node<N>(v);
	 	nodes.append(n);
	 	return n;
	 }

	 public IEdge<N,W>[] getEdgeSet() {
	 	Object[] oa = edges.getarray();
		IEdge<N,W>[] set = (IEdge<N,W>[])new IEdge[oa.length];
		for(int i=0;i<oa.length;i++) { set[i]=(IEdge<N,W>)oa[i]; }
		return set;
	 }

	 public IEdge<N,W>[] getEdgesFrom(INode<N> n) {
	 	ArrayList<IEdge<N,W>> frompaths = new ArrayList<IEdge<N,W>>();
	 	for (int i=0; i<edges.size(); i++) {
	 		if ((edges.fetch(i)).getSource()==n) {
	 			frompaths.append(edges.fetch(i));
	 		}
	 	}
	 	Object[] oa = frompaths.getarray();
	 	IEdge<N,W>[] set = (IEdge<N,W>[])new IEdge[oa.length];
	 	for(int i=0;i<oa.length;i++) { set[i]=(IEdge<N,W>)oa[i]; }
	 	return set;
	 }

	 public IEdge<N,W>[] getEdgesTo(INode<N> n) {
	 	ArrayList<IEdge<N,W>> topaths = new ArrayList<IEdge<N,W>>();
	 	for (int i=0; i<edges.size(); i++) {
	 		if ((edges.fetch(i)).getDestination()==n) {
	 			topaths.append(edges.fetch(i));
	 		}
	 	}
	 	Object[] oa = topaths.getarray();
	 	IEdge<N,W>[] set = (IEdge<N,W>[])new IEdge[oa.length];
	 	for(int i=0;i<oa.length;i++) { set[i]=(IEdge<N,W>)oa[i]; }
	 	return set;
	 }

	 public void addEdge(INode<N> s, INode<N> d, W w) {
	 	IEdge<N,W> n = (IEdge<N,W>) new Edge<N,W>(s,d,w);
	 	edges.append(n);
	 }

	 /*
	 public static void main(String[] args) {
	 	IGraph<String,Integer> graph = (IGraph<String,Integer>) new Graph<String,Integer>();
	 	INode<String> a = graph.addNode("a");
	 	INode<String> b = graph.addNode("b");
	 	INode<String> c = graph.addNode("c");
	 	INode<String> d = graph.addNode("d");
	 	graph.addEdge(a,d,1);
	 	graph.addEdge(c,a,2);
	 	graph.addEdge(d,c,3);
	 	graph.addEdge(a,b,4);
	 	INode<String>[] nset = graph.getNodeSet();
	 	IEdge<String,Integer>[] egset = graph.getEdgeSet();
	 	for (int i=0; i<nset.length; i++) {
	 		System.out.print(nset[i].getValue()+" ");
	 	}
	 	System.out.println();
	 	for (int i=0; i<egset.length; i++) {
	 		System.out.print(egset[i].getWeight()+" ");
	 	}
	 	System.out.println();
	 	INode<String>[] neibofa = graph.getNeighbors(a);
	 	IEdge<String,Integer>[] egtoa = graph.getEdgesTo(a);
	 	IEdge<String,Integer>[] egfra = graph.getEdgesFrom(a);
	 	System.out.println("neighbors");
	 	for (int i=0; i<neibofa.length; i++) {
	 		System.out.print(neibofa[i].getValue()+",");
	 	}
	 	System.out.println();
	 	System.out.println("edges to a");
	 	for (int i=0; i<egtoa.length; i++) {
	 		System.out.print(egtoa[i].getWeight()+",");
	 	}
	 	System.out.println();
	 	System.out.println("edges from a");
	 	for (int i=0; i<egfra.length; i++) {
	 		System.out.print(egfra[i].getWeight()+",");
	 	}
	 	System.out.println();
	 }
	 */
}