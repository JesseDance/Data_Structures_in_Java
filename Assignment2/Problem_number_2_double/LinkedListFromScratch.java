public class LinkedListFromScratch {

	private Node head;
	private Node tail;

	//Once again, I initialized head and tail to be nodes with null data fields like the diagram in the hw pdf
	public LinkedListFromScratch() {
		head = new Node();
		tail = new Node();
		head.next = tail;
	}

	public boolean isEmpty() {
		return head.next == tail;
	}

	//I originally did this with just head and tail as the first and last nodes with data, but after reading the diagram I implemented 
	//head and tail as empty nodes with pointers to first and last nodes with data
	public void addToEnd(int data) {
		Node addedNode = new Node(data);

		if(isEmpty()) {
			head.next = addedNode;
			addedNode.prev = head;
			addedNode.next = tail;
			tail.prev = addedNode;
		} else {
			Node current = head.next;
			while(current.next != tail) {
				current = current.next;
			}
			current.next = addedNode;
			addedNode.prev = current;
			addedNode.next = tail;
			tail.prev = addedNode;
		}
	}


	public void reverseList() {
        Node current = head.next;
        Node nextNode = null;

        //flip head pointers
        head.prev = current;
        head.next = null;

        //flip node pointers
        while (current != tail) {
            nextNode = current.next;
            current.next = current.prev;
            current.prev = nextNode;
            current = nextNode;  
        }
        
        //swap head and tail
        tail = head;
        head = current;

        //flip new head pointers
        head.next = current.prev;
        head.prev = null;

        //now all pointers should be flipped

    }

    //I did not create a separate print in reverse method to show that the 'prev' pointers are correct
    //it wasns't speciffied in the requirements to print both ways, so I didn't do it, but I did make sure that the 'prev' pointers 
    //were correct as far as I can tell, sorry if that makes grading super tedious
	public void printLinkedListFromScratch() {
        if (isEmpty()) {
            System.out.println("Cannot print an empty list");
            return;
        }

        Node current = head.next;
        System.out.print("(NULL) -> ");
        while (current != tail) {
            System.out.print("(" + current.data + ") <-> ");
            current = current.next;
        }
        System.out.println("(NULL)");
    }


}