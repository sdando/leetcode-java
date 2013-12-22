package leetcode;

public class Linked_List_Cycle_II {
	
    public ListNode detectCycle(ListNode head) {
    	if(head==null){
    		return null;
    	}
    	if(head.next==head){
    		return head;
    	}
        ListNode p=head;
        ListNode q=head;
        while(q.next!=null&&q.next.next!=null){
        	p.next.val=0;
        	p=p.next;
        	q=q.next.next;
        	if(p==q){        		
        		q=head;
        		while(q!=p){
        			q.val++;
        			q=q.next;
        		}
        		q=q.next;
        		while(q!=p){
                    q.val++;
        			q=q.next;
        		}
        		q=head;
        		while(q!=p){
        			if(q.val==2)
        				return q;
        		}
        	}
        }
        return null;
    }
}
