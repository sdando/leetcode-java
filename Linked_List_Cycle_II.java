package leetcode;

public class Linked_List_Cycle_II {
	
    public ListNode detectCycle(ListNode head) {
    	if(head==null){
    		return null;
    	}
        ListNode p=head;
        ListNode q=head;
        ListNode preP;
        while(q.next!=null&&q.next.next!=null){
        	p=p.next;
        	q=q.next.next;
        	if(p==q){
        		return p;
        	}
        }
        return null;
    }
}
