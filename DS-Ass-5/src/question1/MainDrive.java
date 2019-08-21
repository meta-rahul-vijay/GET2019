package question1;

import java.util.Scanner;
/**
 * This is main class.
 * @author Rahul Vijay
 * Dated 08/07/2019
 */
public class MainDrive {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		JsonRead jasonRead = new JsonRead();
		bst.root = jasonRead.Json("KeyValue.json");
		Scanner in = new Scanner(System.in);

		int choice;

		
		while (true) {
			System.out.println("1.Insert\n2.Remove\n3.Get Value of a key\n4.Print in sorted Order \n5.Print in sorted from range k1 to k2 \n6.Exit");
			System.out.println("\nselect a choice ");

			choice = in.nextInt();

			switch (choice) {

			case 1:

				System.out.println("enter key ");
				int key = in.nextInt();
				System.out.println("enter value ");
				in.nextLine();
				String value = in.nextLine();
				KeyValuePair keyValue = new KeyValuePair(key, value);
				bst.insert(keyValue);
				break;

			case 2:
				System.out.println("enter key ");
				int keyForRemove = in.nextInt();
				bst.root = bst.remove(keyForRemove);
				break;

			case 3:
				System.out.println("enter key ");
				int keyForFind = in.nextInt();
				String valueForFind = bst.getValue(keyForFind);
				System.out.println(keyForFind + ": " + valueForFind);
				break;

			case 4:
				bst.list.clear();
				System.out.println("Sorted list of key value pair is ");
				bst.sortedList(bst.root);
				for (int index = 0; index < bst.list.size(); index++) {
					System.out.println(bst.list.get(index).key + "  " + bst.list.get(index).value);
				}
				break;

			case 5:
				bst.listRange.clear();
				System.out.print("enter range from ");
				int k1 = in.nextInt();
				System.out.println("to ");
				int k2 = in.nextInt();
				bst.sortedListRange(bst.root, k1, k2);
				System.out.println("Sorted list from " + k1 + " to " + k2);
				for (int index = 0; index < bst.listRange.size(); index++) {
					System.out.println(bst.listRange.get(index).key + "  " + bst.listRange.get(index).value);
				}
				break;

			case 6:
				System.out.println("EXIT");
				System.exit(0);
				

			default:
				System.out.println("Invalid input ");
				break;
			}
		}

	}

}
