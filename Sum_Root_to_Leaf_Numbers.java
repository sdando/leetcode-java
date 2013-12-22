package leetcode;

import org.junit.Test;

import test.JunitTest;

public class Sum_Root_to_Leaf_Numbers {
	
	@Test
	public void test(){
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(1);
		root.left=null;
		JunitTest.Print(new Sum_Root_to_Leaf_Numbers().sumNumbers(root)+"");
	}
	
	private int sum;
	private String s;
    public int sumNumbers(TreeNode root) {
    	if(root==null)
    		return 0;
    	sum=0;
    	s=String.valueOf(root.val);
    	search(root);
        return sum;
    }
    
    private void search(TreeNode root){
    	if(root.left==null&&root.right==null){
    		sum+=Integer.parseInt(s);
    	}
    	if(root.left!=null){
    		s+=root.left.val;
    		search(root.left);
    		s=s.substring(0,s.length()-1);
    	}
    	if(root.right!=null){
    		s+=root.right.val;
    		search(root.right);
    		s=s.substring(0,s.length()-1);
    	}
    }
}
