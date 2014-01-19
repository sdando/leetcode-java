package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Binary_Tree_Level_Order_Traversal_II extends TestCase{
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	class Node{
		private TreeNode node;
		private int level;
		public Node(TreeNode node,int level){
			this.node=node;
			this.level=level;
		}
		public TreeNode getNode(){
			return this.node;
		}
		public int getLevel(){
			return this.level;
		}
	}
	
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(root==null)
        	return ret;
        ArrayList<Integer> oneSeq=new ArrayList<Integer>();
        ArrayDeque<Node> queue=new ArrayDeque<Node>();
        Node front;
        int curLevel,level=1;
        queue.add(new Node(root, 1));
        while(!queue.isEmpty()){
        	front=queue.pop();
        	curLevel=front.getLevel();
        	if(curLevel==level){
        		oneSeq.add(front.getNode().val);
        	}
        	else{
        		ret.add(new ArrayList<Integer>(oneSeq));
        		level=curLevel;
        		oneSeq.clear();
        		oneSeq.add(front.getNode().val);
        	}
        	TreeNode left=front.getNode().left;
        	if(left!=null){
        		queue.add(new Node(left, curLevel+1));
        	}
        	TreeNode right=front.getNode().right;
        	if(right!=null){
        		queue.add(new Node(right, curLevel+1));
        	}
        }
        if(!oneSeq.isEmpty())
        	ret.add(oneSeq);
        Collections.reverse(ret);
        return ret;
    }
}
