package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

import test.JunitTest;

public class Binary_Tree_Preorder_Traversal {
	
	@Test
	public void test(){
		TreeNode node=new TreeNode(1);
		node.left=null;
		node.right=null;
		JunitTest.Print(new Binary_Tree_Preorder_Traversal().preorderTraversal(node).toString());
		
	}
	
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		if (root == null)
			return seq;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode top;
		stack.push(root);
		while (stack.size() != 0) {
			top = stack.pop();
			seq.add(top.val);
			if (top.right != null)
				stack.push(top.right);
			if (top.left != null)
				stack.push(top.left);
		}
		return seq;
    }
}
