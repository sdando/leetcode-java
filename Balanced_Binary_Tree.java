package leetcode;


public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) 
        	return true;
        int lefth=depth(root.left);
        int righth=depth(root.right);
        if(Math.abs(lefth-righth)<=1){
            return isBalanced(root.left)&&isBalanced(root.right);	
        }
        else{ 
        	return false;
        }       
    }
    
    public int depth(TreeNode root){
    	if(root==null) return 0;
    	if(root.left==null&&root.right==null) return 1;
    	int lefth=depth(root.left);
    	int righth=depth(root.right);
    	return lefth>=righth?(lefth+1):(righth+1);
    }
}
