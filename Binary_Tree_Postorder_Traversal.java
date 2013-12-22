package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {

	class StNode{
		public StNode(TreeNode node){
			this.node=node;
			count=0;
		}
		TreeNode node;
		int count;
	}
	
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		if (root == null)
			return seq;
         Stack<StNode> stack=new Stack<StNode>();
         stack.push(new StNode(root));
         StNode topNode;
         while(stack.size()!=0){
        	 topNode=stack.pop();
        	 if(++topNode.count==3){
        		 seq.add(topNode.node.val);
        	 }
        	 else if(topNode.count==2){
        		 stack.push(topNode);
        		 if(topNode.node.right!=null){
        			 stack.push(new StNode(topNode.node.right));
        		 }
        	 }
        	 else{
        		 stack.push(topNode);
        		 if(topNode.node.left!=null){
        			 stack.push(new StNode(topNode.node.left));
        		 }
        	 }
         }
         return seq;
    }
}
