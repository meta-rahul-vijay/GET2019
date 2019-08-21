package question1and2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * This class defines functions for implementation of graph.
 * @author Rahul Vijay
 *
 */
public class Graph implements GraphInterface
{

    private int numberOfVertices;
    private LinkedList<EdgeAndVertices> listOfEdges[];
    private EdgeAndVertices edge;
    private List<EdgeAndVertices> edges;

    public LinkedList<EdgeAndVertices>[] getListOfEdges() {
        return listOfEdges;
    }

    // Constructor to initialize graph with number of vertices and list of edges
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;

        listOfEdges = new LinkedList[numberOfVertices];

        // Initializing the list of vertices
        for (int i = 0; i < this.numberOfVertices; i++) {
            listOfEdges[i] = new LinkedList<>();
        }
    }
    
    /**
     * Function to add edges in graph in case of weighted undirected graph
     * 
     * @param source
     * @param destination
     * @param weight
     */
    public void addEdge(int source, int destination, int weight) {
        // source is connected to destination
        edge = new EdgeAndVertices(source, destination, weight);
        listOfEdges[source].addFirst(edge);
        // destination is also connected to source
        edge = new EdgeAndVertices(destination, source, weight);
        listOfEdges[destination].addFirst(edge);
    }

    /**
     * Helper function to print a graph
     */
    public void printGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            edges = listOfEdges[i];
            for (int j = 0; j < edges.size(); j++) {
                System.out.println("vertex-" + i + " is connected to "
                        + edges.get(j).getDestination() + " with weight "
                        + edges.get(j).getWeight());
            }
        }
    }

    /**
     * method to find DFS of graph
     * @param v
     * @param state
     */
    public void dfs(int v,boolean state[]) {
  
            state[v] = true; 
            // Recur for all the vertices adjacent to this vertex 
            Iterator<EdgeAndVertices> i = listOfEdges[v].listIterator(); 
            while (i.hasNext()) 
            { 
            	EdgeAndVertices n = i.next(); 
                if (!state[n.getDestination()]) 
                    dfs(n.getDestination() ,state); 
            } 
    	
    }
    
    @Override
    public boolean isConnected() {
    	
    	boolean state[] = new boolean[this.numberOfVertices];
    	dfs(0,state);
    	for (int index = 0; index < numberOfVertices; index++) {

    		if (state[index] == false)
    			return false;
    	}
    	return true;
    }
    
    //
    
   
    
    @Override
    public List<Integer> reachable(int vertex) {

        if (vertex >= numberOfVertices) {
            throw new AssertionError("Vertex not in graph");
        }
        List<Integer> listOfReachableVertex = new ArrayList<Integer>();
        
        boolean state[] = new boolean[this.numberOfVertices];
        
    	dfs(vertex,state);
    	for (int index = 0; index < numberOfVertices; index++) {

    		if (state[index] == true)
    			listOfReachableVertex.add(index);
    	}
        
        if (listOfReachableVertex.size() == 0) {
            return null;
        }
        return listOfReachableVertex;
    }

    /**
     * Helper function to find the vertex with minimum key value,
     * from the set of vertices not yet included in MST
     * @param key
     * @param boolSet
     * @return
     */
    int minKey(int key[], Boolean boolSet[]) {
        // Initialize minimum value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < numberOfVertices; v++)
            if (boolSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }
    
    @Override
    public List<EdgeAndVertices> minimumSpanningTree() {

        List<EdgeAndVertices> minSpanningtree;

        int parent[] = new int[numberOfVertices];
        int key[] = new int[numberOfVertices];
        Boolean mstSet[] = new Boolean[numberOfVertices];

        // Initialize all keys as INFINITE
        for (int i = 0; i < numberOfVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0; 
        parent[0] = -1; 

        for (int count = 0; count < numberOfVertices - 1; count++) {

            int u = minKey(key, mstSet);
            mstSet[u] = true;

            edges = listOfEdges[u];

            for (int v = 0; v < numberOfVertices; v++) {

                for (EdgeAndVertices listEdges : edges) {

                    if (listEdges.getDestination() == v) {
                        if (listEdges.getWeight() != 0 && !mstSet[v]
                                && listEdges.getWeight() < key[v]) {

                            parent[v] = u;
                            key[v] = listEdges.getWeight();

                        }
                    }
                }
            }
        }

        minSpanningtree = new ArrayList<>();

        for (int i = 1; i < numberOfVertices; i++) {
            edges = listOfEdges[i];
            for (EdgeAndVertices edgeConnected : edges) {

                if (edgeConnected.getDestination() == parent[i]) {

                    edge = new EdgeAndVertices(parent[i], i,
                            edgeConnected.getWeight());

                    minSpanningtree.add(edge);
                }
            }
        }

        return minSpanningtree;
    }

    @Override
    public List<EdgeAndVertices> shortestPath(int source, int destination) {
        List<EdgeAndVertices> shortestPath;

        int dist[] = new int[numberOfVertices];
       
        Boolean sptSet[] = new Boolean[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[source] = 0;

        for (int count = 0; count < numberOfVertices - 1; count++) {
          
            int u = minKey(dist, sptSet);
            sptSet[u] = true;
            edges = listOfEdges[u];
            
            for (int v = 0; v < numberOfVertices; v++)

                for (EdgeAndVertices listEdges : edges) {
                    // getting weight connected with vertex v
                    if (listEdges.getDestination() == v) {

                        if (!sptSet[v] && listEdges.getWeight() != 0
                                && dist[u] != Integer.MAX_VALUE
                                && dist[u] + listEdges.getWeight() < dist[v]) {

                            dist[v] = dist[u] + listEdges.getWeight();
                        }
                    }
                }
        }

        shortestPath = new ArrayList<>();

        for (int i = source; i < destination + 1; i++) {
            edge = new EdgeAndVertices(i - 1, i, dist[i]);
            shortestPath.add(edge);
        }
        return shortestPath;
    }
  
}