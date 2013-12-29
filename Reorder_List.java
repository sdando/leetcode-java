package leetcode;


import org.junit.Test;

import test.JunitTest;

public class Reorder_List {
	@Test
	public void test(){
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next=null;
//		head.next.next.next=null;
		reorderList(head);
		ListNode p=head;
		while(p!=null){
			JunitTest.Print(p.val+"");
			p=p.next;
		}
	}
	
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        ListNode slow,fast;
        slow=fast=head;
        while(fast!=null&&fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        ListNode p,reversHead=slow.next;
        reversHead=reorder(reversHead);
        ListNode cur=head;
        slow.next=null;
        while(reversHead!=null){
        	p=reversHead.next;
        	reversHead.next=cur.next;
        	cur.next=reversHead;
        	cur=cur.next.next;
        	reversHead=p;
        }   
    }
    
    //if only change head,original passed value not change
    public ListNode reorder(ListNode head){
    	if(head==null||head.next==null)
    		return head;
    	ListNode prev=new ListNode(0);
    	prev.next=head;
    	ListNode tmp,cur=head;
    	while(cur.next!=null){
    		tmp=cur.next;
    		cur.next=tmp.next;
    		tmp.next=prev.next;
    		prev.next=tmp;
    	}
    	head=prev.next;
    	return head;
    }
}
