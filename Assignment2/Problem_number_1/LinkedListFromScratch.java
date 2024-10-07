public class LinkedListFromScratch {
	private Node head;

	public LinkedListFromScratch() {
		head = null;

	}

	public boolean isEmpty() {
		return head == null;
	}


	public void addToEnd(int data) {
		Node addedNode = new Node(data);

		if(isEmpty()) {
			head = addedNode;
		} else {
			Node current = head;

			while (current.next != null) {
				current = current.next;
			}

			current.next = addedNode;
		}
	}

	public void addToBeginning(int data) {
		Node addedNode = new Node(data);
		addedNode.next = head;
		head = addedNode;
	}

	public void rotateList() {
		if (isEmpty()) {
            System.out.println("Cannot rotate an empty list");
            return;
        } 
        if (head.next == null) {
        	System.out.println("Don't need to rotate a list with only one node");
        	return;
        } 

        Node last = head;
        Node secondToLast = null;
        
        while (last.next != null) {
        	secondToLast = last;
        	last = last.next;
        }

        last.next = head;

        secondToLast.next = null;

        head = last;
	}

	public void printLinkedListFromScratch() {
        if (isEmpty()) {
            System.out.println("Cannot print an empty list");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print("(" + current.data + ") -> ");
            current = current.next;
        }
        System.out.println("(NULL)");
    }


}