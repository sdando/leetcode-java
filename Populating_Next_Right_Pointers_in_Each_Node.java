package leetcode;

import java.util.LinkedList;

import org.junit.Test;


class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class Populating_Next_Right_Pointers_in_Each_Node {

	@Test
	public void test(){
		TreeLinkNode node=new TreeLinkNode(1);
		node.next=null;
		node.left=new TreeLinkNode(2);
		node.left.left=null;
		node.left.right=null;
		node.left.next=null;
		node.right=new TreeLinkNode(3);
		node.right.left=null;
		node.right.right=null;
		node.right.next=null;
		connect(node);
	}
	
	LinkedList<TreeLinkNode> queue;
    public void connect(TreeLinkNode root) {
        if(root==null||(root.left==null&&root.right==null))
        	return;
        queue=new LinkedList<TreeLinkNode>();
        queue.add(root);
        doConnect(root);
    }
    
    private void doConnect(TreeLinkNode begin){
    	if(begin==null) return;
    	LinkedList<TreeLinkNode> newQueue=new LinkedList<TreeLinkNode>();
    	TreeLinkNode preNode=begin;
    	while(!queue.isEmpty()){
    		TreeLinkNode node=queue.pollFirst();
    		if(node!=begin){
    			preNode.next=node;
    		}
    		preNode=node;
    		newQueue.add(node.left);
    		newQueue.add(node.right);
    	}
    	queue=newQueue;
    	doConnect(begin.left);
    }
}
