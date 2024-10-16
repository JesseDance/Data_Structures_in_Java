// Java program to demonstrate the
// creation of queue object using the
// LinkedList class

import java.util.*;

class Queue_LinkedList {

    public static void main(String args[])
    {
        // Creating empty LinkedList
        Queue<Integer> queue = new LinkedList<Integer>();

        // Adding items to the ll
        // using add()
        queue.add(10);
        queue.add(20);
        queue.add(15);

        // Printing the top element of
        // the LinkedList
        System.out.println(queue.peek());

        // Printing the top element and removing it
        // from the LinkedList container
        System.out.println(queue.poll());

        // Printing the top element again
        System.out.println(queue.peek());
    }
}
