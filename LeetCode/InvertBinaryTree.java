/*
 * No tester included because I didn't want to go through the 
 * hassle of creating a tree to test. The problem was relatively
 * simple, this algorithm solved all test cases.
 */

public class InvertBinaryTree {
	
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	
	public TreeNode invertTree(TreeNode root) {
        
		if(root == null)
        {
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
		
    }
	
}
