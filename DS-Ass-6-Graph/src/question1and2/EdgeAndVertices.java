package question1and2;


/**
 * This class declares edges and vertices for graph.
 * @author Rahul Vijay
 *
 */
public class EdgeAndVertices
{
    private int source;
    private int destination;
    private int weight;

    public EdgeAndVertices(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * 
     * @return source vertex
     */
    public int getSource() {
        return source;
    }

    /**
     * 
     * @return destination vertex
     */
    public int getDestination() {
        return destination;
    }

    /**
     * 
     * @return weight between source vertex and destination vertex.
     */
    public int getWeight() {
        return weight;
    }
}
