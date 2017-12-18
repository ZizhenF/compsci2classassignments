import java.io.IOException;
import java.io.FileNotFoundException;

public class BreathFirstSearcher<N,W> implements ISearcher<N,W> {
	public BreathFirstSearcher() {};

	public boolean isInList(IList<INode<N>> visited, INode<N> item) {
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
		IList<INode<N>> quetToCheck = new ArrayList<INode<N>>();
		quetToCheck.append(s);

		while (quetToCheck.size()>0) {
			INode<N> toCheck = quetToCheck.fetch(0);
			quetToCheck.remove(0);
			if (this.isInList(visited,toCheck)==false) {
				INode<N>[] nbls = g.getNbsFrIt(toCheck);
				for (int i=0; i<nbls.length; i++) {
					quetToCheck.append(nbls[i]);
				}
				visited.append(toCheck);

				if (toCheck == e) {
					return true;
				}
			}
		}
		return false;
	}

	public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e) {
		IList<INode<N>> visited = new ArrayList<INode<N>>();
		IList<INode<N>> visitedParents = new ArrayList<INode<N>>(); // parallel to visited
		IList<INode<N>> quetToCheck = new ArrayList<INode<N>>();
		IList<INode<N>> checkParents = new ArrayList<INode<N>>(); // parallel to quetocheck
		quetToCheck.append(s);
		checkParents.append(null);
		INode<N> toCheck;
		INode<N> currPar;

		while (quetToCheck.size()>0) {
			toCheck = quetToCheck.fetch(0);
			quetToCheck.remove(0);
			currPar = checkParents.fetch(0);
			checkParents.remove(0);
			if (this.isInList(visited,toCheck)==false) {
				INode<N>[] nbls = g.getNbsFrIt(toCheck);
				for (int i=0; i<nbls.length; i++) {
					quetToCheck.append(nbls[i]);
					checkParents.append(toCheck);
				}
				visited.append(toCheck);
				visitedParents.append(currPar);

				if (toCheck == e) {
					break;
				}
			}
		}

		if (this.isInList(visited,e)==false) {
			return null;
		}
		
		IList<INode<N>> reversePath = new ArrayList<INode<N>>();
		INode<N> currnode = e;
		int curridx=-1;
		while (currnode!=null) {
			reversePath.append(currnode);
			for (int i=0;i<visited.size();i++) {
				if (visited.fetch(i)==currnode) {
					curridx = i;
				}
			}
			currnode = visitedParents.fetch(curridx);
		}

		IList<INode<N>> path = new ArrayList<INode<N>>();
		for (int i=reversePath.size()-2; i>=0; i--) {
			path.append(reversePath.fetch(i));
		}
		return path;
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
		ISearcher<String,Double> searcher = new BreathFirstSearcher<String,Double>();
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