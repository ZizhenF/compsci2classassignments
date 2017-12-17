import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have 
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    Graph<String,Double> r;
    
    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
        r = new Graph<String,Double>();
    }
    
    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        // Open the file
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        // Parse the lines. If a line does not have exactly 3 fields, ignore the line
        // For each line, add the nodes and edge
        String currline = null;
        while((currline = br.readLine())!=null) {
            String[] ls = currline.split(":");
            String n1v = ls[0];
            String n2v = ls[1];
            INode<String> n1 = null;
            INode<String> n2 = null;
            Double egw = new Double(ls[2]);
            // check if nodes already exists, then add new nodes
            boolean n1nonexist = true;
            for (int i=0; i<r.getNodeSet().length; i++) {
                if((r.getNodeSet())[i].getValue().equals(n1v)) {
                    n1nonexist = false;
                    n1 = (r.getNodeSet())[i];
                }
            }
            if (n1nonexist) {
                n1 = r.addNode(n1v);
            }
            boolean n2nonexist = true;
            for (int i=0; i<r.getNodeSet().length; i++) {
                if((r.getNodeSet())[i].getValue().equals(n2v)) {
                    n2nonexist = false;
                    n2 = (r.getNodeSet())[i];
                }
            }
            if (n2nonexist) {
                n2 = r.addNode(n2v);
            }
            // add edge
            r.addEdge(n1,n2,egw);
        }

        // Return the graph instance
        return r;
    }
    
    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}