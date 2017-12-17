import java.io.IOException;
import java.io.FileNotFoundException;

public class DepthFirstSearcher<N,W> implements ISearcher<N,W> {
	boolean exist;
	IList<INode<N>> ndpath;
	public DepthFirstSearcher() {};

	public boolean inList(IList<INode<N>> visited, INode<N> item) {
		boolean iexist = false;
		for (int i=0;i<visited.size();i++) {
			if (visited.fetch(i)==item) {
				iexist = true;
			}
		}
		return iexist;
	}

	public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) {
		IList<INode<N>> visited = new ArrayList<INode<N>>();
		exist = false;
		helper(visited,g,s,e);
		return exist;
	}

	public void helper(IList<INode<N>> visited, IGraph<N,W> g, INode<N> s, INode<N> e) {
		if (s==e) {
			exist = true;
			return;
		}
		else {
			//find the neighbours of s
			INode<N>[] nbls = g.getNbsFrIt(s);
			visited.append(s);
			for (int i=0; i<nbls.length; i++) {
				if (this.inList(visited,nbls[i])==false) {
					this.helper(visited,g,nbls[i],e);

				}
			}
		}
		return;
	}

	public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e) {
		IList<INode<N>> visited = new ArrayList<INode<N>>();
		IList<INode<N>> path = new ArrayList<INode<N>>();
		this.helper2(path,visited,g,s,e);
		if (ndpath==null) {
			return null;
		}
		ndpath.remove(0);
		return ndpath;
	}

	public void helper2(IList<INode<N>> path, IList<INode<N>> visited, IGraph<N,W> g, INode<N> s, INode<N> e) {
		if (s==e) {
			path.append(s);
			ndpath = path;
			return;
		}
		else {
			//find the neighbours of s
			INode<N>[] nbls = g.getNbsFrIt(s);
			visited.append(s);
			IList<INode<N>> newpath = new ArrayList<INode<N>>();
			for (int i=0;i<path.size();i++) {
				newpath.append(path.fetch(i));
			}
			newpath.append(s);
			for (int i=0; i<nbls.length; i++) {
				if (this.inList(visited,nbls[i])==false) {
					this.helper2(newpath,visited,g,nbls[i],e);
				}
			}
		}
		return;
	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DepthFirstSearcher<String,Double> searcher = new DepthFirstSearcher<String,Double>();
		IGraph<String,Double> gr = new Graph<String,Double>();
		IGraphReader reader = new DiGraphReader();
		gr = reader.read("graphfile.cs2");
		INode<String>[] nodels = gr.getNodeSet();
		System.out.println(nodels[1].getValue()+nodels[4].getValue());
		System.out.println(searcher.pathExists(gr,nodels[1],nodels[4]));
		IList<INode<String>> path = searcher.getPath(gr,nodels[1],nodels[4]);
		for (int i=0;i<path.size();i++) {
			System.out.println(path.fetch(i).getValue());
		}
	}
}