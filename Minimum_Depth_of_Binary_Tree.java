package leetcode;

public class Minimum_Depth_of_Binary_Tree {
	
	private int depth;
	private int minDepth;
	
    public int minDepth(TreeNode root) {
        if(root==null)
        	return 0;
        this.depth=1;
        this.minDepth=Integer.MAX_VALUE;
        depth(root);
        return minDepth;
    }
    
    private void depth(TreeNode root){
    	if(root.left==null&&root.right==null){
    		if(depth<minDepth){
    			minDepth=depth;
    		}
    	}
    	if(root.left!=null){
    		depth++;
    		depth(root.left);
    		depth--;
    	}
    	if(root.right!=null){
    		depth++;
    		depth(root.right);
    		depth--;
    	}
    }
}
