
public class Main {
	public static void main(String args[]){
		System.out.println("Linked List Applications");
		LinkedList linkedList =  new LinkedList();
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(7);
		//linkedList.head.next.next.next.next.next = linkedList.head;
		//System.out.println(linkedList.detectLoop().data);
		linkedList.print();
		linkedList.findSubList(-1, 0);
		linkedList.print();
	}
}
