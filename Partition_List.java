package leetcode;

public class Partition_List extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode left_head=new ListNode(-1);
        ListNode right_head=new ListNode(-1);
        ListNode left_cur=left_head;
        ListNode right_cur=right_head;
        for(;head!=null;head=head.next){
        	if(head.val<x){
        		left_cur.next=head;
        		left_cur=head;
        	}
        	else{
        		right_cur.next=head;
        		right_cur=head;
        	}
        }
        left_cur.next=right_head.next;
        right_cur.next=null;
        return left_head.next;
    }
}
