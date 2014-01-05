package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Binary_Tree_Level_Order_Traversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
    	if(root==null)
    		return ret;
    	ArrayList<Integer> level=new ArrayList<Integer>();
    	ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
    	TreeNode front;
    	queue.add(root);
    	queue.add(new TreeNode(Integer.MAX_VALUE));
    	while(true){
    		front=queue.removeFirst();
    		if(front.val==Integer.MAX_VALUE){
    			ret.add(new ArrayList<Integer>(level));
    			level.clear();
    			if(queue.size()==0)
    				break;
    			queue.add(new TreeNode(Integer.MAX_VALUE));
    		}
    		else {
				level.add(front.val);
				if(front.left!=null)
				    queue.add(front.left);
				if(front.right!=null)
				    queue.add(front.right);
			}
    	}
        return ret;
    }
}
