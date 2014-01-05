package leetcode;

public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return doValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean doValid(TreeNode root,int min,int max){
    	if(root==null) return true;
    	if(root.val<= min||root.val>=max)
    		return false;
    	else 
    	    return doValid(root.left, min, root.val)&&doValid(root.right,
    		    root.val, max);
    }
}
