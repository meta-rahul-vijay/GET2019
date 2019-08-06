
public class LinkedList {
	
	Node head;
	public static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	public void addNode(int data){
		Node temp = head;
		while(temp != null && temp.next != null){
			temp = temp.next;
		}
		if(temp == null){
			temp = new Node(data);
			head = temp;
		}else{
			temp.next = new Node(data);
		}
	}
	
	public Node findSubList(int left, int right){
		if(this.head == null || this.head.next == null){
			return this.head;
		}
		int start = 1;
		Node temp = this.head;
		Node prev = null;
		LinkedList subList = new LinkedList();
		while(temp != null && start < left){
			prev = temp;
			temp = temp.next;
			start++;
		}
		while(temp != null && start <= right){
			subList.addNode(temp.data);
			temp = temp.next;
			start++;
		}
		if(subList.head != null){
			subList.head = rotateSubList(subList.head);
			if(prev == null){
				this.head = subList.head;
			}else{
				prev.next = subList.head;
			}
			Node endSubList = subList.head;
			while(endSubList.next != null){
				endSubList = endSubList.next;
			}
			endSubList.next = temp;
		}
		return this.head;
	}
	
	public Node rotateSubList(Node head){
		for(int i = 0 ; i < 2 ; i++){// for two rotations 
			Node temp = head;
			if(head == null || head.next == null){
				return head; 
			}
			while(temp.next.next != null){
				temp = temp.next;
			}
			temp.next.next = head;
			head = temp.next;
			temp.next = null;
		}
		return head;
	}

	public void print() {
		Node temp = head;
		while(temp != null){
			if(temp.next == null){
				System.out.println(temp.data);
				return;
			}
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("\n");
	}

	public Node detectLoop() {
		if(head == null || head.next == null){
			return null;
		}
		Node slow = head;
		Node fast = head;
		
		slow = slow.next;
		fast = fast.next.next;
		while(fast != null && fast.next != null){
			if(slow == fast){
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}	
}
