You should copy in your graph implementation from day11 including the DiGraphReader. You will use your graph implementation to support implementing two different path finding algorithms. DepthFirstSearcher will implement a depth first graph search and conform to the ISearcher interface. BreadthFirstSearcher will implement a breadth first graph search and conform to the ISearcher interface.

We will test your searcher implementations with several graph files. Sometimes a path will exist from the starting node to the target node, sometimes there will not be a path.

You should feel free to use any data structures you have implemented earlier in the block when implementing your searchers.

Files:
IGraph.java        - An interface for a graph implementation
INode.java         - An interface for nodes used by IGraph instances
IEdge.java         - An interface for edges used by IGraph instances
IGraphReader.java  - An interface for reading in graph files
DiGraphReader.java - This file isn't included, please include your day11 implementation
ISearcher.java     - An interface for classes that provide graph searches.
custom_graphfile.cs2      - A simple graph file for a basic test
IList.java         - A List Interface containing some basic list operations
ArrayList.java     - An IList implementation based on array
BreathFirstSearcher.java -An implementation of ISearcher
DepthFirstSearcher.java  -Another implementation of ISearcher
Edge.java          - An IEdge implementation
Graph.java         - An IGraph implemengtation utilizing INode and IEdge
Node.java          - An INode implementation