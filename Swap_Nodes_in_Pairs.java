package leetcode;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null)
    		return head;
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        ListNode pre=preHead;
        ListNode cur1=head;
        ListNode cur2=head.next;
        ListNode temp;
        while(cur1!=null&&cur2!=null){
        	cur1.next=cur2.next;
        	cur2.next=cur1;
        	pre.next=cur2;
        	pre=cur1;
        	temp=cur1;
        	cur1=cur2;
        	cur2=temp;
        	if(cur1.next!=null)
        	    cur1=cur1.next.next;
        	if(cur2.next!=null)
        	    cur2=cur2.next.next;
        }
        return preHead.next;
    }
}
