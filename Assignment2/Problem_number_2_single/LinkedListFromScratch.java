public class LinkedListFromScratch {
	private Node head;
	private Node tail;

	public LinkedListFromScratch() {
		head = new Node();
		tail = new Node();
        head.next = tail;
	}

	public boolean isEmpty() {
		return head.next == tail;
	}


	public void addToEnd(int data) {
		Node addedNode = new Node(data);

		if(isEmpty()) {
			head.next = addedNode;
			addedNode.next = tail;
		} else {

            Node current = head.next;

            while (current.next != tail) {
                current = current.next;
            }

            current.next = addedNode;

			addedNode.next = tail;
		}
	}

    // all the diagrams of head and tail that I have seen have the first and last element as head and tail
    // however, since the diagram on the homework instructions has head and tail containing null data fields before and after
    // the list is filled and reversed, I have chosen to implement the list as described in the diagram.
	public void reverseList() {
        Node current = head.next;
        Node next = null;
		Node previous = head;

        if (isEmpty()) {
            System.out.println("Cannot reverse an empty list");
            return;
        } 

        while (current != tail) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        head.next = null;
        tail = head;
        head.next = previous;
    }

	public void printLinkedListFromScratch() {
        if (isEmpty()) {
            System.out.println("Cannot print an empty list");
            return;
        }

        Node current = head.next;

        System.out.print("(NULL) -> ");
        while (current != tail) {
            System.out.print("(" + current.data + ") -> ");
            current = current.next;
        }
            System.out.println("(NULL)\n");
    }


}