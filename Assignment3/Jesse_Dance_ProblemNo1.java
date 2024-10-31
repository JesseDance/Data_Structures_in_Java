import java.util.*;

class Hashtable {

	private int capacity;
	private KeyValuePair[] table;
	private int size;
	private final int MAX_CAPACITY = 1000;
	
	public static class KeyValuePair {
		int key;
		int value;
		KeyValuePair next;

		KeyValuePair(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

	}

	public Hashtable(int initialCapacity) {
		this.capacity = initialCapacity;
		this.table = new KeyValuePair[capacity];
		this.size = 0;
	}

	private int hash(int key) {
		return key % capacity;
	}

	private void rehash() {
        
        int newCapacity = Math.min(capacity * 2, MAX_CAPACITY);
        KeyValuePair[] oldTable = table;
        capacity = newCapacity;
        table = new KeyValuePair[capacity];

        for (KeyValuePair pair : oldTable) {
	        while (pair != null) {
	            
	            int index = hash(pair.key);
	            KeyValuePair newPair = new KeyValuePair(pair.key, pair.value);
	            
	            KeyValuePair current = table[index];
	            if (current == null) {
	                table[index] = newPair; 
	            } else {
	                while (true) {
	                    if (current.next == null) {
	                        current.next = newPair;
	                        break;
	                    }
	                    current = current.next; 
	                }
	            }
	            pair = pair.next; 
	        }
	    }
	    System.out.println("Table has been rehashed to new capacity: " + newCapacity);
	}

    public void insert(int key, int value) {

        int index = hash(key);
        KeyValuePair newPair = new KeyValuePair(key, value);

        KeyValuePair current = table[index];
        if (current == null) {
            table[index] = newPair; 
        } else {
            while (true) {  
	            if (current.next == null) {
	                current.next = newPair; 
	                break;
	            }
	            current = current.next;
	        }            
        }
    size++;
    if ((double) size / capacity >= 0.6) {
	        rehash();
    	}
    }

    public void printKeyIndex(int key) {
    	int keyIndex = hash(key);

    	System.out.printf("The key %d is at the index %d", key, keyIndex);
    }

    public void printTable() {
	    System.out.println("\nCurrent Hash Table:");
	    for (int i = 0; i < capacity; i++) {
	        KeyValuePair current = table[i];
	        if (current != null) {
	            System.out.print("Index " + i + ": ");
	            while (current != null) {
	                System.out.print("[" + current.key + ": " + current.value + "] -> ");
	                current = current.next;
	            }
	            System.out.println("null"); 
	        } else {
	            System.out.println("Index " + i + ": null");
		    }
	    }
	    System.out.printf("Current Load Factor: %.2f%n", (double) size / capacity);

	}

}


public class Jesse_Dance_ProblemNo1 {


	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the initial size of your table: ");

		int initialCapacity = Integer.parseInt(in.nextLine().trim());

		Hashtable ht = new Hashtable(initialCapacity);

		System.out.println("Now you can enter your key(int) value(int) pairs, -1 to exit");
		
		while (true) {
			System.out.println("Enter a key(or -1 to exit): ");
            int keyEntry = in.nextInt();
            if (keyEntry == -1) 
            {
                break;  
            } 

            System.out.println("Now enter the value for this key: ");
            int valueEntry = in.nextInt();

            ht.insert(keyEntry, valueEntry);

            ht.printKeyIndex(keyEntry);
            ht.printTable();      
        }

        in.close();
	}
}