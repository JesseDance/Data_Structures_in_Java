import java.util.ArrayList; 
 
public class Binary_Search_Tree_ArrayList { 
    private ArrayList<Integer> tree; 
 
    public Binary_Search_Tree_ArrayList() { 
        tree = new ArrayList<>(); 
    } 
 
    // Insert a value into the binary tree 
    public void insert(int value) { 
        tree.add(value); 
    } 
 
    // Get the left child index 
    private int leftChildIndex(int index) { 
        return 2 * index + 1; 
    } 
 
    // Get the right child index 
    private int rightChildIndex(int index) { 
        return 2 * index + 2; 
    } 
 
    // Get the parent index 
    private int parentIndex(int index) { 
        return (index - 1) / 2; 
    } 
 
    // Print the tree (in-order traversal) 
    public void inOrderTraversal(int index) { 
        if (index < tree.size()) { 
            inOrderTraversal(leftChildIndex(index)); 
            System.out.print(tree.get(index) + " "); 
            inOrderTraversal(rightChildIndex(index)); 
        } 
    } 
 
    // Main method for testing 
    public static void main(String[] args) { 
        Binary_Search_Tree_ArrayList binaryTree = new Binary_Search_Tree_ArrayList(); 
        binaryTree.insert(10); 
        binaryTree.insert(5); 
        binaryTree.insert(15); 
        binaryTree.insert(3); 
        binaryTree.insert(7); 
        binaryTree.insert(12); 
        binaryTree.insert(18); 
 
        System.out.println("In-order Traversal:"); 
        binaryTree.inOrderTraversal(0); // Start from the root 
    } 
} 