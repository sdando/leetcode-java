package leetcode;

public class Reverse_Linked_List_II extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		ListNode node=new ListNode(0);
		node.next=new ListNode(1);
		node.next.next=new ListNode(2);
		ListNode head=reverseBetween(node, 1, 2);
		return;
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode pre=null,start,p;
        int i;
        p=preHead;   
        for(i=1;i<=m;i++){
        	pre=p;
        	p=p.next;
        }
        start=p;
        p=p.next;
        for(i=m;i<n;i++){
        	start.next=p.next;
        	p.next=pre.next;
        	pre.next=p;
        	p=start.next;
        }
        return preHead.next;
    }
}
