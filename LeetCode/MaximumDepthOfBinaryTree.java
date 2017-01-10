
public class MaximumDepthOfBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args)
	{
		
	}
	
	public int maxDepth(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        else if(root.left == null && root.right == null) {
            return 1;
        }
        
        else if(root.left != null && root.right != null) {
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
        
        else if(root.left != null) {
            return 1 + maxDepth(root.left);
        }
        
        else {
            return 1 + maxDepth(root.right);
        }
        
        
    }
	
}
