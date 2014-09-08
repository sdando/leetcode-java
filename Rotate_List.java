package leetcode;

public class Rotate_List extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null||head.next==null||n==0) return head;
        ListNode q=head;
        ListNode p=head;
        int count=0;
        while(p!=null){
        	count++;
        	p=p.next;
        }
        if(count<n) n=n%count;
        if(n==0) return head;
        while(n--!=0&&q!=null){
        	q=q.next;
        }
        if(q==null) return head;
        p=head;
        while(q.next!=null){
        	p=p.next;
        	q=q.next;
        }
        ListNode ret=p.next;
        p.next=null;
        q.next=head;
        return ret;
    }
}
