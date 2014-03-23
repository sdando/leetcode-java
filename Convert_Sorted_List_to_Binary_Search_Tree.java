package leetcode;


public class Convert_Sorted_List_to_Binary_Search_Tree extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		TreeNode root=sortedListToBST(head);
		return;

	}
	ListNode head;
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
    	int length=0;
    	ListNode node=head;
    	while(node!=null){
    		length++;
    		node=node.next;
    	}
    	this.head=head;
    	return sortedListToBST(0, length-1);
    }
    
    public TreeNode sortedListToBST(int start,int end){
    	if(start>end) return null;
    	int mid=start+(end-start)/2;
    	TreeNode left=sortedListToBST(start,mid-1);
    	TreeNode root=new TreeNode(head.val);
    	root.left=left;
    	head=head.next;
    	TreeNode right=sortedListToBST(mid+1, end);
    	root.right=right;
    	return root;
    }
}
