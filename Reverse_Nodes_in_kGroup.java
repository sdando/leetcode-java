package leetcode;

public class Reverse_Nodes_in_kGroup extends TestCase {

	@Override
	public void test() {
		// TODO Auto-generated method stub
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode ret=reverseKGroup(head, 3);
        return;
	}
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2) return head;
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        int count;
        ListNode cur=head,p,pre=preHead;
        while(cur!=null){
        	count=1;
        	p=cur.next;
            while(p!=null&&count<k){
                cur.next=p.next;
                p.next=pre.next;
                pre.next=p;
                p=cur.next;
                count++;
            }
            if(count<k){
            	p=pre.next;
            	while(p!=cur){
            		pre.next=p.next;
            		p.next=cur.next;
            		cur.next=p;
            		p=pre.next;
            	}
            	break;
            }
        	pre=cur; 
            cur=cur.next;
        }
        return preHead.next;
    }
}
