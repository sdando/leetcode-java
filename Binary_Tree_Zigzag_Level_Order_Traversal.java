package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Binary_Tree_Zigzag_Level_Order_Traversal extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        ArrayList<ArrayList<Integer>> ret=zigzagLevelOrder(root);
        return;
	}
	
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
        if(root==null) return ret;
        LinkedList<TreeNode> dequeue=new LinkedList<TreeNode>();
        ArrayList<Integer> level=new ArrayList<Integer>();
        int i=1;
        TreeNode node;
        dequeue.addLast(root);
        dequeue.add(null);
        while(dequeue.size()!=0){
            node=dequeue.pop();
            if(node!=null){
            	level.add(node.val);
            	if(node.left!=null) dequeue.add(node.left);
            	if(node.right!=null) dequeue.add(node.right);
            }
            else{
            	if(i%2!=0){
            		ret.add(new ArrayList<Integer>(level));
            	}
            	else{
            		Collections.reverse(level);
            		ret.add(new ArrayList<Integer>(level));
            	}
        		level.clear();
        		i++;
        		if(dequeue.size()!=0) dequeue.add(null);
            }
        }
        return ret;
    }
}
