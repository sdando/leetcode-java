package leetcode;

public class Maximum_Depth_of_Binary_Tree {
	
	private int depth;
	private int maxDepth;
    public int maxDepth(TreeNode root) {
        if(root==null)
        	return 0;
        this.depth=1;
        this.maxDepth=Integer.MIN_VALUE;
        depth(root);
        return maxDepth;
    }
    private void depth(TreeNode root){
    	if(root.left==null&&root.right==null){
    		if(depth>maxDepth){
    			maxDepth=depth;
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
