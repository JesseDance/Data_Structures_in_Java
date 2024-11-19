import java.util.*;

public class JesseDance_ProblemNo1 {

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val; 
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

	public static TreeNode buildTree(List<Integer> treeNodes, int index) {

        if (index >= treeNodes.size() || treeNodes.get(index) == null) {
            return null;
        }

        TreeNode currentNode = new TreeNode(treeNodes.get(index));

        currentNode.left = buildTree(treeNodes, 2 * index + 1);
        currentNode.right = buildTree(treeNodes, 2 * index + 2);

        return currentNode;
    }

    public static boolean validPathToTarget(TreeNode root, int targetSum) {

        if(root == null) { 
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return validPathToTarget(root.left, targetSum - root.val) || validPathToTarget(root.right, targetSum - root.val); 
    }

	
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		List<Integer> treeNodes = new ArrayList<>();
 
		System.out.println("Please begin entering the nodes of the tree beginning with the root: ");

		while (true) {
			System.out.println("Enter the next node(or -1 to exit): ");
            String input = in.nextLine().trim();
            if (input.equals("-1"))
            {
                break;  
            } 
            if (input.equals("null"))
            	treeNodes.add(null);
            else 
            	treeNodes.add(Integer.parseInt(input));
        }

        System.out.println("Finally, input the targetSum: ");

        int target = Integer.parseInt(in.nextLine().trim());

        TreeNode root = buildTree(treeNodes, 0);

        if(validPathToTarget(root,target)) {
        	System.out.println("There is a valid root-to-leaf path");
        }
        else{
        	System.out.println("There is no valid root-to-leaf path");
        }

    }
	
}