package question1;
/**
 *  This class is used to create a node of bst.
 * @author Rahul Vijay
 * Dated 08/07/2019
 */
public class Node {
	
	public KeyValuePair data;
	Node leftNode;
	Node rightNode;
	
	/**
	 * Constructor of Node.
	 * @param data, data to be insert.
	 */
	Node(KeyValuePair data) {
		this.data = data;	
	}

}
