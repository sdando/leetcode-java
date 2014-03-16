package leetcode;


public class Populating_Next_Right_Pointers_in_Each_Node_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		TreeLinkNode node=new TreeLinkNode(1);
		node.left=new TreeLinkNode(2);
		node.right=new TreeLinkNode(3);
		connect(node);
		return;
	}
	
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode dummy=new TreeLinkNode(-1);
        for(TreeLinkNode cur=root,prev=dummy;root!=null;root=root.next){
        	if(root.left!=null){
        		prev.next=root.left;
        		prev=prev.next;
        	}
        	if(root.right!=null){
        		prev.next=root.right;
        		prev=prev.next;
        	}
        }
        connect(dummy.next);
    }

}
