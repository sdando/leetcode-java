package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class Binary_Tree_Inorder_Traversal {
	
	@Test
	public void test(){
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=null;
		inorderTraversal(node);
	}
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> seq=new ArrayList<Integer>();
        if(root==null)
        	return seq;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        TreeNode popNode;
        while(cur!=null||!stack.isEmpty()){
        	while(cur!=null){
        		stack.push(cur);
        		cur=cur.left;
        	}
        	popNode=stack.pop();
        	seq.add(popNode.val);
        	cur=popNode.right;
        	while(cur==null&&!stack.isEmpty()){
        		popNode=stack.pop();
        		seq.add(popNode.val);
        		cur=popNode.right;
        	}
        }
        return seq;
    }
}
