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
		ISearcher<String,Double> searcher = new DepthFirstSearcher<String,Double>();
		IGraph<String,Double> gr = new Graph<String,Double>();
		IGraphReader reader = new DiGraphReader();
		gr = reader.read("custom_graphfile.cs2");
		INode<String>[] nodels = gr.getNodeSet();
		INode<String> start = null;
		INode<String> end = null;
		for (int i=0;i<nodels.length;i++) {
			if (nodels[i].getValue().equals("start")) {
				start = nodels[i];
			}
			if (nodels[i].getValue().equals("end")) {
				end = nodels[i];
			}
		}
		System.out.println(start.getValue()+end.getValue());
		System.out.println(searcher.pathExists(gr,start,end));
		IList<INode<String>> path = searcher.getPath(gr,start,end);
		for (int i=0;i<path.size();i++) {
			System.out.println(path.fetch(i).getValue());
		}
	}
}