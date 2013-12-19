package leetcode;

import org.junit.Test;

import test.JunitTest;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	    val = x;
        next = null;
	}
}

public class Linked_List_Cycle {
	
	@Test
	public void test(){
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(3);
		l1.next=l2;
		l2.next=l1;
		JunitTest.Print(new Linked_List_Cycle().hasCycle(l1)+"");
	}
	
    public boolean hasCycle(ListNode head) {
    	if(head==null){
    		return false;
    	}
        ListNode p=head;
        ListNode q=head;
        while(q.next!=null&&q.next.next!=null){
        	p=p.next;
        	q=q.next.next;
        	if(p==q){
        		return true;
        	}
        }
        return false;
    }
}
