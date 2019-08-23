package question1;

import java.util.ArrayList;
/**
 * This class is used to create a binary search tree.
 * @author Rahul Vijay
 * Dated 08/07/2019
 */
public class BinarySearchTree {
	Node root;
	ArrayList<KeyValuePair> list;
	ArrayList<KeyValuePair> listRange;
	/**
	 * constructor of a binarySearchtree for initialize root to null;
	 */
	BinarySearchTree() {
		root = null;
		list = new ArrayList<>();
		listRange = new ArrayList<>();
	}

	/**
	 * This method is used to insert data in bst.
	 * @param data, data to be insert.
	 */
	public void insert(KeyValuePair data) {
		root = insertNode(root, data);
	}

	/**
	 * This method is used to insert data in bst.
	 * @param root, root of bst.
	 * @param data, data to be inserted.
	 * @return, this return root of the bst.
	 */
	public Node insertNode(Node root, KeyValuePair data) {

		if (root == null)
			root = new Node(data);

		if (root.data.key > data.key)
			root.leftNode = insertNode(root.leftNode, data);
		else if (root.data.key < data.key)
			root.rightNode = insertNode(root.rightNode, data);

		return root;
	}

	/**
	 * This method is used to find minimum value of a node.
	 * @param root, root of tree.
	 * @return, this return minimum value.
	 */
	private Node findMin(Node root) {

		while (root.leftNode != null) {

			root = root.leftNode;
		}

		return root;
	}

	/**
	 * This method is used to remove data from bst.
	 * @param data, data to be removed.
	 * @return, this return root of bst.
	 */
	public Node remove(int data) {
		root = delete(root, data);
		return root;

	}

	/**
	 * This method is used to delete data from bst.
	 * @param root, root of bst.
	 * @param data, data to be deleted.
	 * @return, this return root of bst.
	 */
	private Node delete(Node root, int data) {

		if (root == null) {

			return root;
		} else if (root.data.key > data) {
			root.leftNode = delete(root.leftNode, data);
		} else if (root.data.key < data) {
			root.rightNode = delete(root.rightNode, data);
		} else {
			if ((root.leftNode == null) && (root.rightNode == null)) {
				root = null;
			} else if (root.leftNode == null) {
				root = root.rightNode;
			} else if (root.rightNode == null) {
				root = root.leftNode;
			} else {

				Node temp = findMin(root.rightNode);
				root.data.key = temp.data.key;
				root.data.value = temp.data.value;
				root.rightNode = delete(root.rightNode, temp.data.key);

			}
		}

		return root;

	}

	/**
	 * This method is used to get value of a key.
	 * @param data, data to be inserted.
	 * @return, this return value of particular key.
	 */
	public String getValue(int data) {

		Node node = root;
		while (node != null) {

			if (node.data.key == data) {
				return node.data.value;
			} else if (node.data.key < data) {
				node = node.rightNode;
			} else
				node = node.leftNode;
		}

		return "value no found";
	}

	/**
	 * This method is used to sort data using inorder traverse.
	 * @param root, root of tree.
	 */
	public void sortedList(Node root) {

		if (root == null) {
			return;
		}

		sortedList(root.leftNode);
		list.add(root.data);
		sortedList(root.rightNode);

	}

	/**
	 * This method is used to sort data from range k1 to k2.
	 * @param root, root of tree.
	 * @param K1, starting point of sorting.
	 * @param K2, end point of sorting.
	 */
	public void sortedListRange(Node root, int K1, int K2) {

		if (root == null) {
			return;
		}

		sortedListRange(root.leftNode, K1, K2);

		if (root.data.key >= K1 && root.data.key <= K2)
			listRange.add(root.data);

		sortedListRange(root.rightNode, K1, K2);
	}

	/**
	 * This print bst in preorder traverse.
	 * @param root, root of tree.
	 */
	public void preOrder(Node root) {

		if (root == null) {
			return;
		}

		System.out.println(root.data.key + "  " + root.data.value);
		preOrder(root.leftNode);
		preOrder(root.rightNode);

	}

}
